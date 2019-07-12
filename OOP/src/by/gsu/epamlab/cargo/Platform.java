package by.gsu.epamlab.cargo;


public class Platform extends AbstractCargo {
	private double cargoMass;
	
	
	public Platform(Substance substance, double mass) {
		super(substance, 0);
		this.cargoMass = mass;
	}
	
	public Platform() {
		super();
	}

	public double getCargoMass() {
		return cargoMass;
	}

	public void setCargoMass(double cargoMass) {
		this.cargoMass = cargoMass;
	}

	@Override
	public double getMass() {
		
		return cargoMass;
	}

	@Override
	protected String fieldsToString() {
		return super.fieldsToString() + ";" + cargoMass;
	}

	
}
