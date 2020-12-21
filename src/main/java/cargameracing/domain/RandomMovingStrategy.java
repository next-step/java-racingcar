package cargameracing.domain;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    public static final int FORWARD_NUM = 4;

    @Override
    public boolean isMove() {
        return new Random().nextInt(10) >= FORWARD_NUM;
    }
}
