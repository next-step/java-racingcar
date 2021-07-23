package racing.car;

import util.RandomUtils;

import java.util.function.BooleanSupplier;

public class Fuel {
    public static Fuel EMPTY = new Fuel(0);
    public static Fuel FULL = new Fuel(9);

    private int value;

    private Fuel(int value) {
        this.value = value;
    }

    public static Fuel newInstance(int value) {
        return new Fuel(value);
    }

    public static Fuel randomInstance() {
        return new Fuel(
                RandomUtils.nextInt(FULL.value));
    }

    public boolean isMovable(int requireFuelValue) {
        return this.value >= requireFuelValue;
    }
}
