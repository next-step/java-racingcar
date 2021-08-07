package racingcar;

import java.util.Random;

public class Car {

    private int position;

    public Car() {
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void move(int randomNum) {
        if (randomNum >= 4) {
            position++;
        }
    }
}
