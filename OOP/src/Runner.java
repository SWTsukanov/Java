import by.gsu.epamlab.*;
import by.gsu.epamlab.cargo.Cistern;
import by.gsu.epamlab.cargo.Container;
import by.gsu.epamlab.cargo.Platform;
import by.gsu.epamlab.cargo.Substance;
import by.gsu.epamlab.people.Passenger;
public class Runner {

	public static void main(String[] args) {
		ICargo[] peopleAndCargo = new ICargo[] {
				new Passenger("Sergey", 80),
				new Container(Substance.STEEL, 1500, 7, 4, 1.8),
				new Platform(Substance.STEEL, 250),
				new Passenger("Yulia", 50),
				new Cistern(Substance.GLYCEROL, 900, 5, 1.5),
				new Container(Substance.COPPER, 700, 3, 2, 1.8),
				new Cistern(Substance.KEROSENE, 1200, 6, 1.5),
		};
		Ferry ferry = new Ferry(150000, peopleAndCargo);
		ferry.showAll();
		System.out.println();
		ferry.sort();
		ferry.showAll();
		System.out.println();
		if(ferry.isReady()) {
			System.out.println("Ferry is ready");
		}
		else {
			System.out.println("Ferry overloaded");
		}
		
	}

}
