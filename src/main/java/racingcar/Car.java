package racingcar;

import java.util.Random;

public class Car {

    private static final int STARTING_POINT = 0;
    private static final int RULE_OF_MOVE = 4;

    private int position;

    public Car() {
        this.position = STARTING_POINT;
    }

    public void move(int randomNumber) {
        if (randomNumber >= RULE_OF_MOVE)
            this.position += 1;
    }

    public int getPosition() {
        return this.position;
    }

}
