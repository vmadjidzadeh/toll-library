package toll.business.policy;

/**
 * The main pricing policy abstract class which defines only one abstract method which will be overridden
 * by implementing classes. 
 *
 */
public abstract class PricingPolicy {
	
	/**
	 * Calculates a bill depending on the hours spent by a car in slot
	 * @param hours the hours spent by the car
	 * @return calculated bill
	 */
	public abstract double calculateBill(int hours);

}
