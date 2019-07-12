package by.gsu.epamlab;

import by.gsu.epamlab.Constants;

import by.gsu.epamlab.Purchase;

public class PurchasesFactory {

    public static Purchase getClassFromFactory (String csvLine) {
        String[] values = csvLine.split(Constants.DELIMETER);

            String name = values[Constants.NAME_INDEX];
            int price = Integer.parseInt(values[Constants.PRICE_INDEX]);
            int number = Integer.parseInt(values[Constants.NUMBER_INDEX]);

            if (values.length == Constants.PURCHASE_LENGHT) {
                return new Purchase(name, price, number);
            } else {

                int priceDiscount = Integer.parseInt(values[Constants.PRICE_DISCOUNT]);
                return new PriceDiscountPurchase(name, new Byn(price), number, priceDiscount);
            }
    }
}
