package by.gsu.epamlab;

import java.util.Arrays;

public class Ferry {
	private double maxMass;
	private ICargo[] peopleAndCargo;
	public Ferry(double maxMass, ICargo[] peopleAndCargo) {
		super();
		this.maxMass = maxMass;
		this.peopleAndCargo = peopleAndCargo;
	}
	public Ferry() {
		super();
	}
	public double getMaxMass() {
		return maxMass;
	}
	public void setMaxMass(double maxMass) {
		this.maxMass = maxMass;
	}
	public ICargo[] getPeopleAndCargo() {
		return peopleAndCargo;
	}
	public void setPeopleAndCargo(ICargo[] peopleAndCargo) {
		this.peopleAndCargo = peopleAndCargo;
	}
	public void showAll() {
		for(ICargo iterator:peopleAndCargo) {
			System.out.println(iterator);
		}
	}
	
	public boolean isReady() {
		double summMass = 0;
		for(ICargo iterator:peopleAndCargo) {
			summMass += iterator.getMass();
		}
		if (summMass < maxMass) {
			return true;
		}
		return false;
	}
	
	public void sort() {
		Arrays.sort(peopleAndCargo,new CompareEntities());
	}
	
	

}
