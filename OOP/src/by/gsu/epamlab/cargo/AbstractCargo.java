package by.gsu.epamlab.cargo;

import by.gsu.epamlab.ICargo;

public abstract class AbstractCargo implements ICargo {
	private Substance substance;
	private double mass;
	
	
	public AbstractCargo(Substance substance, double mass) {
		super();
		this.substance = substance;
		this.mass = mass;
	}
	public AbstractCargo() {
		super();
	}
	public Substance getSubstance() {
		return substance;
	}
	public void setSubstance(Substance substance) {
		this.substance = substance;
	}
	public double getMass() {
		return mass;
	}
	public void setMass(double mass) {
		this.mass = mass;
	}
	
	protected String fieldsToString() {
		return substance.name() + ";" + mass;
	}
	@Override
	public String toString() {
		String mass = String.format("%.3f", getMass());;
		return getClass().getSimpleName() + ";" + fieldsToString() + ";" + mass ;
	}
	
	
	

}
