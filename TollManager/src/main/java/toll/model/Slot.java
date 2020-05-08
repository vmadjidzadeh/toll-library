package toll.model;

import java.util.Date;

/**
 * Class representing a slot of a car in toll parking.
 * A slot has a unique number, an availability status and a type depending on the booked car
 *
 */
public class Slot {

	/**
	 * Constructor instantiating a new slot
	 * @param number number of the slot
	 * @param type type of the slot
	 * @param isFree availability of the slot
	 */
	public Slot(String number, String type, boolean isFree) {
		this.number = number;
		this.isFree = isFree;
		this.type = type;
	}
	
	/**
	 * The unique identifier of the slot
	 */
	private String number;

	/**
	 * Boolean representing the availability of the slot
	 */
	private boolean isFree;

	/**
	 * The type of the slot depending on the car type booking this slot
	 */
	private String type;

	/**
	 * The arrival time of the car booking this slot
	 */
	private Date arrivalTime;
	
	/**
	 * The departure time of the car booking this slot
	 */
	private Date departueTime;
	
	
	/**
	 * The unique number of the slot
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}
	
	/**
	 * Sets the number of the slot
	 * @param number to be associated to the slot
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	
	/**
	 * Method to know if the slot is free
	 * @return boolean on the status of the slot
	 */
	public boolean isFree() {
		return isFree;
	}
	
	/**
	 * Updates the status of the slot
	 * @param isFree the status as boolean
	 */
	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	/**
	 * Gets the type of this slot
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type
	 * @param number
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the arrival time
	 * @return the arrivalTime
	 */
	public Date getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * Sets the arrivalTime
	 * @param arrivalTime the arrival time for this slot
	 */
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	/**
	 * Gets the departurTime
	 * @return the departure time
	 */
	public Date getDepartueTime() {
		return departueTime;
	}

	/**
	 * Sets the departure time
	 * @param departueTime the departure time
	 */
	public void setDepartueTime(Date departueTime) {
		this.departueTime = departueTime;
	}

}
