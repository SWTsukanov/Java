package by.gsu.epamlab;

import java.util.Scanner;

public class PriceDiscountPurchase extends Purchase {

	private Byn discount;
	
	public PriceDiscountPurchase() {
		
	}

	public PriceDiscountPurchase(String name, Byn price, int number,int discont) {
		super(name, price, number);
		this.discount = new Byn(discont);
	}
	
	public PriceDiscountPurchase(Scanner scanner) {
		super(scanner);
		this.discount =new Byn( scanner.nextInt() );
	}

	public Byn getDiskont() {
		return discount;
	}

	public void setDiskont(Byn diskont) {
		this.discount = diskont;
	}

	
	public Byn getCost() {
		Byn sumDiscount = new Byn(discount).mul( getNumber() );
		return  new Byn(super.getCost()).sub(sumDiscount);
	}

	@Override
	public String toString() {
		return  fieldsToString() + ";" + getCost();
	}
	
	protected String fieldsToString() {
		return super.fieldsToString() + ";" + discount;
	}
	

	
}
