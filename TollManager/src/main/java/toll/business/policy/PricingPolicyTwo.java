package toll.business.policy;

/**
 * Implementation of {@link PricingPolicy}, calculates a bill depending on the booking hours plus a fix amount.
 *
 */
public class PricingPolicyTwo extends PricingPolicy {
	
	private static final int FIX_AMOUNT = 8;

	private static final int PRICE_PER_HOUR = 10;

	@Override
	public double calculateBill(int hours) {
		return FIX_AMOUNT + PRICE_PER_HOUR * hours;
	}

}
