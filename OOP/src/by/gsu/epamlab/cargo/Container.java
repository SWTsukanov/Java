package by.gsu.epamlab.cargo;

public class Container extends AbstractCargo {
	private double lendth;
	private double width;
	private double hight;
		
	public Container(Substance substance, double mass, double lendth, double width, double hight) {
		super(substance, mass);
		this.lendth = lendth;
		this.width = width;
		this.hight = hight;
	}

	public Container() {
		super();
	}

	public double getLendth() {
		return lendth;
	}

	public void setLendth(double lendth) {
		this.lendth = lendth;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHight() {
		return hight;
	}

	public void setHight(double hight) {
		this.hight = hight;
	}

	@Override
	public double getMass() {
		return super.getMass()+ lendth * width * hight * getSubstance().getDensity();
	}

	@Override
	protected String fieldsToString() {
		return super.fieldsToString() + ";" + lendth + ";" + width + ";" + hight;
	}

	
}
