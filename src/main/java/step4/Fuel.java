package step4;

import java.util.Random;

public class Fuel {

    private static final int MAXIMUM_NUMBER = 9;
    private static final int VALID_NUMBER = 4;
    private Random fuel;

    public Fuel() {
        this.fuel = getRandom();
    }

    protected Random getRandom() {
        return new Random();
    }

    public boolean isValid(){
        return this.fuel.nextInt(MAXIMUM_NUMBER) >= VALID_NUMBER;
    }

    public boolean equals(Object o) {
        Fuel f = (Fuel) o;
        return getClass().equals(f.getClass());
    }
}