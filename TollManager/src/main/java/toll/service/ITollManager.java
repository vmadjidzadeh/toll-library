package toll.service;

import toll.business.policy.PricingPolicy;
import toll.exceptions.CarNotFoundException;
import toll.exceptions.SlotIndexException;
import toll.exceptions.SlotNotFoundException;

/**
 * 
 * Interface representing the main entry point which handles the two toll parking operations<p>
 *
 * The API exposed by this interface will do the following for cars that comes in and out randomly
 * 
 *<ul>
 *  <li>Send them to the right parking slot or refuse them if there is no slot (of the right type) left</li>
 *  <li>Mark the parking slot as Free when the car leaves it</li>
 *  <li>Bill the customer when the car leaves</li>
 *  <li>Allows to update the pricing policy</li>
 *</ul> 
 *  
 *
 */
public interface ITollManager {
	
	
	/**
	 * Books a slot type represented by <code>carType</code>, see
	 * @param carType the type of the car
	 * @return a free slot number if any left, null otherwise
	 * @throws SlotIndexException if no free slot left
	 * @throws CarNotFoundException if carType car is not handled
	 */
	public String bookSlot(String carType)  throws SlotIndexException, CarNotFoundException;
	
	/**
	 * Makes the slot available with the number <code>slotId</code>
	 * Calculates and returns the bill for that slot time range 
	 * @param slotId the slot number to be charged
	 * @return the bill amount
	 * @throws SlotNotFoundException slot number was not found
	 */
	public double getCarDepartureBill(String slotId) throws SlotNotFoundException ;

	/**
	 * Updates the pricing policy of the current toll parking
	 * @param policy the new pricing policy to be applied, it can only extend a {@link PricingPolicy}
	 */
	public <T extends PricingPolicy> void updatePolicy(T policy) ;

}
