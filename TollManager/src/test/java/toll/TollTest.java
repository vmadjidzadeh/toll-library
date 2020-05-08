package toll;

import static org.junit.Assert.assertTrue;
import static toll.model.Car.ELEC_20KW;
import static toll.model.Car.ELEC_50KW;
import static toll.model.Car.SEDAN;

import org.junit.Test;

import toll.business.policy.PricingPolicy;
import toll.business.policy.PricingPolicyOne;
import toll.business.policy.PricingPolicyTwo;
import toll.exceptions.SlotIndexException;
import toll.exceptions.SlotNotFoundException;
import toll.model.Slot;
import toll.resources.SlotsDB;
import toll.service.ITollManager;
import toll.service.TollManager;

/**
 * Main test class simulating the behavior of a toll parking
 *
 */
public class TollTest {

	@Test
	public void test() {
		PricingPolicy policyOne = new PricingPolicyOne();
		ITollManager tollManager = new TollManager();
		tollManager.updatePolicy(policyOne);
		
		//STEP 1
		//The SlotsDB contains 9 free slots, 4 sedan, 3 20kw and 2 50kw cars
		//For this test we book 4 sedan, 3 20kw and 1 50kw
		
		boolean noExcpetion = true;
		int exceptions = 0;
		
		try {
			tollManager.bookSlot(SEDAN);
			tollManager.bookSlot(SEDAN);
			tollManager.bookSlot(SEDAN);
			tollManager.bookSlot(SEDAN);
			tollManager.bookSlot(ELEC_20KW);
			tollManager.bookSlot(ELEC_20KW);
			tollManager.bookSlot(ELEC_20KW);
			tollManager.bookSlot(ELEC_50KW);
		} catch (SlotIndexException e) {	
			noExcpetion = false;
		}
		
		//At this point, no more sedan and no more 20kw are left
		//9 slots where booked, only one 50kw is left
		assertTrue(freeSlots() == 1);
		
		//STEP 2
		//Trying to book a new sedan car, sedan slots are full, so an exception is raised
		String slotNumber = null;
		try {
			slotNumber = tollManager.bookSlot(SEDAN);
		} catch (SlotIndexException e) {
			exceptions++;
		}		
		
		assertTrue(slotNumber == null);
		//STEP 3
		//The car on slot with number 02 leaves, the bill is calculated and it is 15 and so one
		//new slot is free again
		double bill = 0;
		try {
			bill = tollManager.getCarDepartureBill("02");
		} catch (SlotNotFoundException e) {
			noExcpetion = false;
		}
		assertTrue(bill == 15.0);
		assertTrue(freeSlots() == 2); //new free slot

		
		//STEP 4
		//A sedan slot became available at step 3, but still 20kw slots are full, so when trying to
		//book a 20kw car, an exception is raised
		try {
			slotNumber = tollManager.bookSlot(ELEC_20KW);
		} catch (SlotIndexException e) {
			exceptions++;
		}
		assertTrue(slotNumber == null);
		assertTrue(freeSlots() == 2); //free slots are still 2

		
		//STEP 5
		//20kw slots are full as seen at step 4 but a sedan slot is available thanks to step 3
		try {
			slotNumber = tollManager.bookSlot(SEDAN);
		} catch (SlotIndexException e) {
			noExcpetion = false;
		}		
		assertTrue(slotNumber.equals("02")); // the number of the available sedan slot is 02
		assertTrue(freeSlots() == 1); //free slots is now 1
		

		//STEP 6
		//A 20kw car is leaving from slot 05, so a new 20kw slot will be available
		try {
			bill = tollManager.getCarDepartureBill("05");
		} catch (SlotNotFoundException e1) {
			noExcpetion = false;
		}
		assertTrue(bill == 15.0);
		assertTrue(freeSlots() == 2);

		//STEP 7
		//As a 20kw slot is available, we can book a 20kw slot again
		try {
			slotNumber = tollManager.bookSlot(ELEC_20KW);
		} catch (SlotIndexException e) {
			noExcpetion = false;
		}
		assertTrue(slotNumber.equals("05"));		
		assertTrue(freeSlots() == 1);

		
		//STEP 8
		//Updating the pricing policy, the bill will now change from 15 to 18 for one hour
		tollManager.updatePolicy(new PricingPolicyTwo());
		try {
			bill = tollManager.getCarDepartureBill("02");
		} catch (SlotNotFoundException e) {
			noExcpetion = false;
		}
		assertTrue(bill == 18.0);

		//STEP 9
		//An slot with an unknown number tries to leave and calculate billing, an exception is raised
		double billNotDefined = 0.0;
		try {
			billNotDefined = tollManager.getCarDepartureBill("AAA");
		} catch (SlotNotFoundException e) {
			exceptions++;
		}
		assertTrue(billNotDefined == 0.0);
		
		//STEP 10
		//A 50kw car books the last 50kw slot left
		try {
			slotNumber = tollManager.bookSlot(ELEC_50KW);
		} catch (SlotIndexException e) {
			noExcpetion = false;
		}
		assertTrue(slotNumber.equals("09"));		
		assertTrue(freeSlots() == 1);
		
		//Assert no excpetions were raised when not relevant
		assertTrue(noExcpetion);
		
		//Assert 3 exceptions were raised
		assertTrue(exceptions == 3);			
	}
	
	private int freeSlots() {
		int slots = 0;
		for (Slot slot : SlotsDB.SLOTS) {
			if (slot.isFree()) slots++;
		}
		return slots;
	}

}
