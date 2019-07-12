package by.gsu.epamlab;

public class Byn implements Comparable<Byn>{
	
	private int coins;

	public Byn() {
		super();
	}

	public Byn(int value) {
		super();
		this.coins = value;
	}
	
	public Byn(int rubs, int penny ) {
		this(rubs * 100 + penny);
	}
	public Byn(Byn byn) {
		this(byn.coins);
	}
	
	@Override
	public String toString() {
		int rubles = coins / 100;
		int tenths = (coins / 10) % 10;
		int hundreds = coins % 10;
		return rubles + "." + tenths + hundreds;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + coins;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Byn other = (Byn) obj;
		if (coins != other.coins)
			return false;
		return true;
	}

	public int getRubs() {
		return coins / 100;
	}

	public int getCoins() {
		return coins % 100;
	}
	
	public Byn add(int value) {
		coins += value;
		return this;
	}
	public Byn add(Byn value) {
		coins += value.coins;
		return this;
	}
	
	public Byn sub(int value) {
		coins -= value;
		return this;
	}
	public Byn sub(Byn value) {
		coins -= value.coins;
		return this;
	}
	
	public Byn mul(int number) {
		coins *= number;
		return this;
	}
	
	public Byn mul(double number, int scale, Rouding mode) {
		coins = mode.round(coins * number, scale);
		return this;
	}
	
	public Byn div(double number, int scale, Rouding mode) {
		coins =  mul(1 / number, scale, mode).coins ;
		return this;
	}
	
	public Byn round(int scale, Rouding mode) {
		coins = mode.round(coins, scale);
		return this;
	}

	@Override
	public int compareTo(Byn o) {
		return coins - o.coins;
	}
	

}

