package step3;

import java.util.Random;

public class RacingDice implements Dice {
    static final int BOUND = 10;

    @Override
    public int getRandomNum() {
        return new Random().nextInt(BOUND);
    }

}
