package racing;

import java.util.Random;

public class Umpire {

    private Random random = new Random();
    private int advanceCondition;
    private final int MOVE_NUMBER = 4;

    private final int POSSIBLE_NUMBER = 10;

    public void resetAdvanceCondition() {
        this.advanceCondition = random.nextInt(POSSIBLE_NUMBER);
    }

    public boolean isGoStraight() {
        return this.advanceCondition >= MOVE_NUMBER;
    }

}
