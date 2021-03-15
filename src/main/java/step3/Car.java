package step3;

import java.util.function.Predicate;

public class Car {

    private int currentPosition;
    private String carName;

    public Car() {
        currentPosition = 0;
    }

    public Car(String carName) {
        this.currentPosition = 0;
        this.carName = carName;
    }

    public void moveForward(int number, Predicate<Integer> p) {
        if (p.test(number)) {
            currentPosition++;
        }
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    public String getCarName() {
        return this.carName;
    }

}
