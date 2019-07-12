package by.gsu.epamlab;

public enum Rouding {
	CEIL {
        double roundFunction(double k) {
            return Math.ceil(k);
        }
    },
    FLOOR {
        double roundFunction(double k) {
            return Math.floor(k);
        }
    },
    ROUND {
        double roundFunction(double k) {
            return Math.round(k);
        }
    };
	private final int[] tenPowD = {1, 10, 100, 1_000, 10_000, 100_000, 1_000_000, 10_000_000, 100_000_000};
    abstract double roundFunction(double k);
    
     int round(double roundedValue, int d) {
    	int tenPow = tenPowD[d];
		int result = (int) roundFunction(roundedValue / tenPow) * tenPow;
		return result;

	}

}



