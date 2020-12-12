package cargameracing;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    public static final int FINAL = 4;

    @Override
    public boolean isMove() {
        return new Random().nextInt(10) >= FINAL;
    }
}
