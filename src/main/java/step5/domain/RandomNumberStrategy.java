package step5.domain;

import step5.util.RandomNumberGenerator;

public class RandomNumberStrategy implements MovingStrategy{

    private final int MOVABLE_BOUNDARY = 3;
    @Override
    public boolean isMovable() {
        int randomNumber = RandomNumberGenerator.generate();
        return randomNumber > MOVABLE_BOUNDARY;
    }
}
