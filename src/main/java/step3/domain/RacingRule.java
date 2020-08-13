package step3.domain;

import java.util.Random;

public class RacingRule implements RacingMoveRule {

    private static final Random random = new Random();
    private static final int RANGE = 10;
    private static final int MOVE_NUMBER = 4;

    private int randomNumber;

    public RacingRule() {

        this.randomNumber = 0;
    }

    @Override
    public boolean moveRule() {

        makeRandomNumber();

        if (randomNumber > MOVE_NUMBER) {
            return true;
        }

        return false;
    }

    public int makeRandomNumber() {
        return randomNumber = random.nextInt(RANGE);
    }
}
