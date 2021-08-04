package study.step3.model.strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int CAR_MOVE_CONDITION = 4;
    private static final int RANDOM_NUMBER_BOUND = 10;

    int randomNumber;

    public RandomMoveStrategy() {
        randomNumber = generatorRandomNumber();
    }

    public RandomMoveStrategy(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    @Override
    public boolean isMoveCondition() {
        return (randomNumber >= CAR_MOVE_CONDITION);
    }

    private int generatorRandomNumber() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis() * random.nextInt());
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }
}