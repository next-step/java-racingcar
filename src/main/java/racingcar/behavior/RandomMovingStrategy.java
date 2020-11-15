package racingcar.behavior;

import java.util.function.IntSupplier;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int MAX_NUM = 9;
    private static final int BASE_LINE_NUM = 4;

    private final IntSupplier randomSupplier;

    public RandomMovingStrategy() {
        this.randomSupplier = () -> new RandomNumber(MAX_NUM + 1).getBoundNumber();
    }

    @Override
    public boolean isMovable() {
        return random() >= BASE_LINE_NUM;
    }

    private int random() {
        return randomSupplier.getAsInt();
    }
}
