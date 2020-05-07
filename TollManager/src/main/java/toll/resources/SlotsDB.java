package toll.resources;

import static toll.model.Car.ELEC_20KW;
import static toll.model.Car.ELEC_50KW;
import static toll.model.Car.SEDAN;

import java.util.ArrayList;
import java.util.List;

import toll.model.Slot;

/**
 * A database of available slots. It contains 4 sedan, 3 20KW and 2 50KW car slots.
 * At first initialization all slots are free.
 *
 */
public class SlotsDB {
	
	public static List<Slot> SLOTS = new ArrayList<>();
	

	
	public static void init() {
		Slot slot = new Slot("01", SEDAN, true);
		SLOTS.add(slot);
		slot = new Slot("02", SEDAN, true);
		SLOTS.add(slot);
		slot = new Slot("03", SEDAN, true);
		SLOTS.add(slot);
		slot = new Slot("04", SEDAN, true);
		SLOTS.add(slot);
		slot = new Slot("05", ELEC_20KW, true);
		SLOTS.add(slot);
		slot = new Slot("06", ELEC_20KW, true);
		SLOTS.add(slot);
		slot = new Slot("07", ELEC_20KW, true);
		SLOTS.add(slot);
		slot = new Slot("08", ELEC_50KW, true);
		SLOTS.add(slot);
		slot = new Slot("09", ELEC_50KW, true);
		SLOTS.add(slot);
		
	}

}
