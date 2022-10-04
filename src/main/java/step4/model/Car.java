package step4.model;

import java.util.Random;

public class Car {

    private String carName;
    private int location;
    private final static Random random = new Random();
    private final int ADVANCED_NUMBER = 4;

    public Car(String carName, int location) {
        this.carName = carName;
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

    public String currentName() {
        return this.carName;
    }

    private boolean isAdvanced(int value) {
        return value >= ADVANCED_NUMBER;
    }

}
