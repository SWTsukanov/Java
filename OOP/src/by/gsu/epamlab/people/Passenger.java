package by.gsu.epamlab.people;

import by.gsu.epamlab.ICargo;

public class Passenger implements ICargo {
	
	private String Name;
	private double mass;
	
	
	public Passenger() {
		super();
	}


	public Passenger(String name, double mass) {
		super();
		Name = name;
		this.mass = mass;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public void setMass(double mass) {
		this.mass = mass;
	}


	


	@Override
	public String toString() {
		return getClass().getSimpleName() + ";" + Name + ";" + mass;
	}


	@Override
	public double getMass() {
		return mass;
	}

}
