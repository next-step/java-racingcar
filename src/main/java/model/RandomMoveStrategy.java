package model;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private final Random rand = new Random();

    @Override
    public boolean isMovable() {
        return rand.nextInt(10) >= 4;
    }
}
