package step3;

import java.util.Random;

public class Car {

    private int location;
    private final int ADVANCED_VALUE = 4;

    public Car(int location) {
        this.location = location;
    }

    public int advanceCar(int randomValue) {
        if(isAdvanced(randomValue)) {
            this.location++;
            return this.location;
        }
        return this.location;
    }

    public int currentLocation() {
        return this.location;
    }

    private boolean isAdvanced(int value) {
        return value >= ADVANCED_VALUE;
    }

}
