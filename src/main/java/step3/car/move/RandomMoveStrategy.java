package step3.car.move;

import step3.RandomNumberCreator;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int VERIFY_START_MOVE_NUMBER = 4;
    private static final int VERIFY_END_MOVE_NUMBER = 9;
    private final RandomNumberCreator randomNumberCreate;
    private static final int MOVE = 1;
    private static final int ZERO = 0;


    public RandomMoveStrategy(RandomNumberCreator randomNumberCreate) {
        this.randomNumberCreate = randomNumberCreate;
    }

    @Override
    public int move() {
        if (canMove()) {
            return MOVE;
        }
        return ZERO;
    }

    @Override
    public boolean canMove() {
        int randomNumber = getRandomNumber();
        return randomNumber >= VERIFY_START_MOVE_NUMBER && randomNumber <= VERIFY_END_MOVE_NUMBER;
    }

    private int getRandomNumber() {
        return randomNumberCreate.getRandomNumber();
    }
}
