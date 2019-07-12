import by.gsu.epamlab.Byn;
import by.gsu.epamlab.EntryChecker;
import by.gsu.epamlab.PriceDiscountPurchase;
import by.gsu.epamlab.Purchase;
import by.gsu.epamlab.PurchasesFactory;
import by.gsu.epamlab.WeekDay;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Runner {

	private static <K, V> void printMap(Map<K, V> map, String header) {
		System.out.println(header);
		for (Map.Entry<K, V> m : map.entrySet()) {
			System.out.print(m.getKey() + " => ");
			System.out.println(m.getValue());
		}
	}

	private static <K, V> V find(Map<K, V> map, K key, String header) {
		V value = map.get(key);
		if (value == null) {
			System.out.println(header + " --> " + "Purchase is not found.");
		} else {
			System.out.println(header + " --> " + value);
		}
		return value;
	}

	private static void delete(Map<Purchase, WeekDay> map, EntryChecker entryCheckable) {
		Set<Map.Entry<Purchase, WeekDay>> entrySet = map.entrySet();
		Iterator<Map.Entry<Purchase, WeekDay>> iter = entrySet.iterator();
		while (iter.hasNext()) {
			Map.Entry<Purchase, WeekDay> entry = iter.next();
			if (entryCheckable.check(entry)) {
				iter.remove();
			}
		}
	}

	private static <T extends Purchase> Byn totalCost(List<T> purchases) {
		Byn totalCost = new Byn();
		for (T p : purchases) {
			totalCost.add(p.getCost());
		}
		return totalCost;
	}

	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new FileReader("src/in.csv"));
			Map<Purchase, WeekDay> firstPurchaseMap = new HashMap<Purchase, WeekDay>();
			Map<Purchase, WeekDay> lastPurchaseMap = new HashMap<Purchase, WeekDay>();
			List<PriceDiscountPurchase> pricePurchases = new ArrayList<PriceDiscountPurchase>();
			Map<WeekDay, List<Purchase>> purchasesInDay = new EnumMap<WeekDay, List<Purchase>>(WeekDay.class);

			while (scanner.hasNext()) {
				Purchase purchase = PurchasesFactory.getClassFromFactory(scanner.nextLine());

				WeekDay day = WeekDay.valueOf(scanner.nextLine());
				if (!firstPurchaseMap.containsKey(purchase)) {
					firstPurchaseMap.put(purchase, day);
				}

				lastPurchaseMap.put(purchase, day);

				if (purchase instanceof PriceDiscountPurchase) {
					PriceDiscountPurchase pricePurchase = (PriceDiscountPurchase) purchase;
					pricePurchases.add(pricePurchase);
				}

				List<Purchase> purchases = purchasesInDay.get(day);
				if (purchases == null) {
					purchasesInDay.put(day, purchases = new ArrayList<Purchase>());
				}
				purchases.add(purchase);

			}

			printMap(firstPurchaseMap, "There are purchases in first day");
			System.out.println();
			printMap(lastPurchaseMap, "There are purchases in last day");
			System.out.println();

			find(firstPurchaseMap, new Purchase("bread", 155, 0),
					"We found the first weekdays for bread with price 1.55");
			find(lastPurchaseMap, new Purchase("bread", 155, 0),
					"We found the last weekdays for bread with price 1.55");
			find(firstPurchaseMap, new Purchase("bread", 170, 0),
					"We found the first weekday for bread with price 1.70");
			System.out.println();

			delete(firstPurchaseMap, new EntryChecker() {
				public boolean check(Map.Entry<Purchase, WeekDay> entry) {
					if (entry.getKey().getName().equals("meat"))
						return true;
					return false;
				};
			});
			delete(lastPurchaseMap, new EntryChecker() {
				public boolean check(Map.Entry<Purchase, WeekDay> entry) {
					if (entry.getValue().equals(WeekDay.FRIDAY))
						return true;
					return false;
				};
			});

			printMap(firstPurchaseMap, "There are purchases in first day after delete");
			System.out.println();
			printMap(lastPurchaseMap, "There are purchases in last day after delete");
			System.out.println();
			System.out.println("Total cost in List = " + totalCost(pricePurchases));
			System.out.println();
			printMap(purchasesInDay, "There are all purchases in weekday");
			System.out.println();
			for (Map.Entry<WeekDay, List<Purchase>> entry : purchasesInDay.entrySet()) {
				System.out.println("Total cost in " + entry.getKey() + "  =>  " + totalCost(entry.getValue()));
			}
			System.out.println();
			find(purchasesInDay, WeekDay.MONDAY, "We found all purchases in Monday");

		} catch (FileNotFoundException e) {
			System.err.println("File is not found!!!");
		} finally {
			if (scanner != null)
				scanner.close();
		}

	}

}