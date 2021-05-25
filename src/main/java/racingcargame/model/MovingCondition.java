package racingcargame.model;

import java.util.Random;

public class MovingCondition {
    private Random random = new Random();

    public int getNumber() {
        return random.nextInt(10);
    }
}
