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
	 * The type of the slot depending on the car type 
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
	 * @return
	 */
	public String getNumber() {
		return number;
	}
	
	/**
	 * @param number
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	
	/**
	 * @return
	 */
	public boolean isFree() {
		return isFree;
	}
	
	/**
	 * @param isFree
	 */
	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	/**
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param number
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return
	 */
	public Date getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * @param number
	 */
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	/**
	 * @return
	 */
	public Date getDepartueTime() {
		return departueTime;
	}

	public void setDepartueTime(Date departueTime) {
		this.departueTime = departueTime;
	}

}
