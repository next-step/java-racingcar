package step3;

import java.util.function.Predicate;

public class Car {

    private int currentPosition;

    public Car() {
        currentPosition = 0;
    }

    public Car(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void moveForward(int number, Predicate<Integer> p) {
        if (p.test(number)) {
            currentPosition++;
        }
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

}
