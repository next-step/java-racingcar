package step5.domain;

import step5.util.NumberGenerator;

public class RandomDrivingStrategy implements MovingStrategy {

    @Override
    public int move() {
        return NumberGenerator.createRandomNumbers();
    }
}
