package toll.dao;

import java.util.Date;

import toll.model.Slot;
import toll.resources.SlotsDB;

/**
 * An implementation of the {@link ITollDAO} library that relies on the {@link SlotsDB} database
 *
 */
public class TollDAOStatic implements ITollDAO {
	
	public TollDAOStatic() {
		SlotsDB.init();
	}

	@Override
	public Slot bookSlot(String type) {

		Slot slot = getFreeSlot(type);
		
		if (slot != null) {
			slot.setFree(false);
			slot.setArrivalTime(new Date());
		}
		return slot;
	}

	@Override
	public Slot freeSlot(String slotId) {
		for(Slot slot :  SlotsDB.SLOTS) {
			if (slot.getNumber().equals(slotId)) {
				slot.setFree(true);
				return slot;
			}
		}
		return null;
	}

	/**
	 * Finds the first free slot that matches a <code>carType</code> car type
	 * @param carType the type of the car
	 * @return the Slot object that is free
	 */
	private Slot getFreeSlot(String carType) {
		for(Slot slot : SlotsDB.SLOTS) {
			if (slot.getType().equals(carType) && slot.isFree()) {
				return slot;
			} 
		}
		return null;
	}

}
