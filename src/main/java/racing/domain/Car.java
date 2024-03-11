package racing.domain;

import static racing.domain.RandomNumber.canForword;
import static racing.domain.RandomNumber.makeRandomNumber;

public class Car {

    private static final int ZERO = 0;
    private int position;

    public Car() {
        this.position = ZERO;
    }

    public void forward() {
        if(canForword(makeRandomNumber())) {
            position ++;
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "position=" + position +
                '}';
    }
}
