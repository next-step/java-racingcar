package study.step_3;

import java.util.Random;

public class Car {
    private static final int CONDITION = 4;
    private int position;

    public void position(int randomNumber) {
        if (randomNumber >= CONDITION) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
