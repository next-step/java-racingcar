package step3;

import java.util.function.Predicate;

public class Car {

    private int currentPosition;

    public void moveForward(int number, Predicate<Integer> p) {
        if (p.test(number)) {
            currentPosition++;
        }
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

}
