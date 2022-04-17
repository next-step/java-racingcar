package model;

import java.util.Random;

public class RandomMoveRule implements MoveRule {

    private static final int DEFAULT_RANDOM_NUMBER_BOUND = 9;
    private static final int DEFAULT_MOVE_FORWARD_VALUE = 4;
    private static final Random random = new Random();

    private boolean isMoveForward;


    public boolean isMoveForward() {
        int randomNumber = random.nextInt(DEFAULT_RANDOM_NUMBER_BOUND);

        if (randomNumber >= DEFAULT_MOVE_FORWARD_VALUE) {
            this.isMoveForward = true;
        }

        return isMoveForward;
    }
}
