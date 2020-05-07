package toll.dao;

import toll.model.Slot;
import toll.service.TollManager;

/**
 * An API of the DAO used by {@link TollManager}
 * The advantage of providing this interface is that any toll parking manager can easily change its 
 * persistence backend solution without changing its implementation.
 *
 */
public interface ITollDAO {
	
	/**
	 * Books a slot type represented by <code>slot</code>
	 * @param carType the type of the car
	 * @return a free slot if any left, null otherwise
	 */
	public Slot bookSlot(String carType);
	
	/**
	 * Makes the slot with number slotId available again, passes Slot to free status.
	 * @param slotId the number of the slot
	 * @return the {@link Slot} object with number slotId that is now free
	 * 			null if no slot was found
	 */
	public Slot freeSlot(String slotId);

}
