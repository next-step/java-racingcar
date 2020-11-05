package racingcar.behavior;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int MAX_NUM = 9;
    private static final int BASE_LINE_NUM = 4;

    private Integer randomSupplier;
    RandomNumber randomNumber = new RandomNumber(MAX_NUM + 1);

    public RandomMovingStrategy() {
        this.randomSupplier = randomNumber.getBoundNumber();
    }

    @Override
    public boolean isMovable() {
        return random() >= BASE_LINE_NUM;
    }

    private int random() {
        return randomSupplier;
    }
}
