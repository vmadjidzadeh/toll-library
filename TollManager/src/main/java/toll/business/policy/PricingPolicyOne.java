package toll.business.policy;

/**
 * Implementation of {@link PricingPolicy}, calculates a bill depending on the booking hours
 *
 */
public class PricingPolicyOne extends PricingPolicy {
	
	
	private static final int PRICE_PER_HOUR = 15;

	@Override
	public double calculateBill(int hours) {
		return PRICE_PER_HOUR * hours;
	}

}
