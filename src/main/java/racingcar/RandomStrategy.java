package racingcar;

public class RandomStrategy implements MoveStrategy {

    private final static int MIN_NUM_TO_MOVE = 4;

    private final RandomNumber randomNumber;

    public RandomStrategy(RandomNumber randomNumber) {
        this.randomNumber = randomNumber;
    }

    @Override
    public boolean movable() {
        return randomNumber.getRandomNumber() >= MIN_NUM_TO_MOVE;
    }
}
