package by.gsu.epamlab.cargo;

public enum Substance {
	STEEL(7850), COPPER(8500), KEROSENE(800), GLYCEROL(1260) ;
	
	private final double density;
	
	private Substance(double density) {
		this.density = density;
	}

	public double getDensity() {
		return density;
	}
	
	
	


}
