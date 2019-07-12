package by.gsu.epamlab.cargo;


public class Cistern extends AbstractCargo {
	private double length;
	private double radius;
	
	
	public Cistern(Substance substance, double mass, double length, double radius) {
		super(substance, mass);
		this.length = length;
		this.radius = radius;
	}
	
	public Cistern() {
		super();
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	
	@Override
	protected String fieldsToString() {
		return super.fieldsToString() + ";" + length + ";" + radius;
	}

	@Override
	public double getMass() {
		return length * Math.PI * radius * radius * super.getSubstance().getDensity() + super.getMass();
	}

}
