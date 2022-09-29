package racingcar.strategy;

import java.util.Random;

public class RandomStrategy implements MovingStrategy {

    private final int lowerBound;
    private final int highBound;

    public RandomStrategy(int lowerBound, int highBound) {
        this.lowerBound = lowerBound;
        this.highBound = highBound;
    }

    @Override
    public boolean isMove() {
        int value = new Random().nextInt(highBound);
        return lowerBound <= value && value <= highBound;
    }
}
