package racingcar;

import java.util.Random;

public class Car {
    private String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
        position = 0;
    }

    public Car(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public String carName() {
        return this.carName;
    }

    public int position() {
        return this.position;
    }

    public int max(int other) {
        if (this.position > other){
            return this.position;
        }
        return other;
    }

    public void updatePosition(int randomValue) {
        if (randomValue >= 4) {
            position++;
        }
    }

    public boolean isMatch(int maxPosition) {
        return maxPosition == this.position;
    }
}
