package toll.service;

import java.util.Arrays;
import java.util.Date;

import toll.business.policy.PricingPolicy;
import toll.dao.ITollDAO;
import toll.dao.TollDAOStatic;
import toll.exceptions.CarNotFoundException;
import toll.exceptions.SlotIndexException;
import toll.exceptions.SlotNotFoundException;
import toll.model.Car;
import toll.model.Slot;

/**
* 
 * This class is an implementation {@link ITollManager}
 *
 */
public class TollManager implements ITollManager {
	
	
	/**
	 * The pricing policy to apply
	 */
	private PricingPolicy pricingPolicy;
	
	/**
	 * The DAO solution to apply
	 */
	ITollDAO tollDAO = new TollDAOStatic();
	
	@Override
	public String bookSlot(String carType) throws SlotIndexException, CarNotFoundException {
		
		if (!Arrays.stream(Car.values()).anyMatch((t) -> t.name().equals(carType))) {
			throw new CarNotFoundException();
		}

		
		Slot slot = tollDAO.bookSlot(carType);

		if (slot == null) {
			throw new SlotIndexException();
		}
		return slot.getNumber();
	}
	
	@Override
	public double getCarDepartureBill(String slotId) throws SlotNotFoundException {
		double resultingBill = 0;

		Slot slot = tollDAO.freeSlot(slotId);				
		if (slot != null) {
			slot.setDepartueTime(new Date());
			resultingBill = getBill(slot);
		} else {
			throw new SlotNotFoundException();
		}
		return resultingBill;
	}

	@Override
	public <T extends PricingPolicy> void updatePolicy(T policy) {
		this.pricingPolicy = policy;
	}

	/**
	 * Calculates the hours between arrival and departure of the car, then pass it the chosen
	 * pricing policy calculator to get the bill
	 * @param slot the slot upon which the bill is calculated
	 * @return bill amount
	 */
	private double getBill(Slot slot) {
		long secs = (slot.getDepartueTime().getTime() - slot.getArrivalTime().getTime()) / 1000;
		int hours = (int) secs / 3600;    
		return pricingPolicy.calculateBill(hours + 1);
	}

}
