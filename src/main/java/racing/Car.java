package racing;

import java.util.Random;

public class Car {
    private static final int GO_CONDITION = 4;

    private int position = 0;

    public void move(int randomNumber) {
        if (randomNumber >= GO_CONDITION) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
