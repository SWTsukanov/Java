package by.gsu.epamlab;

import java.util.Map;

public interface  EntryChecker {
	boolean check(Map.Entry<Purchase, WeekDay> entry);
}
