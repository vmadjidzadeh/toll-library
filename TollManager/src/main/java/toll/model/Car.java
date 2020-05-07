package toll.model;

/**
 * The Car object. The only relevant information for the current toll pricing policy is the car type.
 *
 */
public class Car {
	
	
	/**
	 * Sedan car type 
	 */
	public static final String SEDAN 		= "CAR_01";	
	
	/**
	 * 20kw electric cars
	 */
	public static final String ELEC_20KW 	= "CAR_02";

	/**
	 * 50kw electric car type 
	 */
	public static final String ELEC_50KW 	= "CAR_03";

	/**
	 * The type of the car
	 */
	private String type;
	
	/**
	 * Returns the car type
	 * @return the car type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the car type
	 * @param type the type of the to be set
	 */
	public void setType(String type) {
		this.type = type;
	}

}
