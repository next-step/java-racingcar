package step4;

import java.util.Random;

public class RacingDice implements Dice {
    static final int BOUND = 10;

    @Override
    public int getNum() {
        return new Random().nextInt(BOUND);
    }

}
