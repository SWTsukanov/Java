package by.gsu.epamlab;

import java.util.Comparator;

public class CompareEntities implements Comparator<ICargo> {

	@Override
	public int compare(ICargo o1, ICargo o2) {
		return Entities.valueOf( o1.getClass().getSimpleName() ).ordinal() - 
				Entities.valueOf( o2.getClass().getSimpleName() ).ordinal();
	}

	
}
