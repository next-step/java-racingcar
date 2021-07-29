package step5.strategy;

import step5.util.NumberGenerator;

public class RandomDrivingStrategy implements MovingStrategy {

    @Override
    public int move() {
        return NumberGenerator.createRandomNumbers();
    }
}
