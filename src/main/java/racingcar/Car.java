package racingcar;

import java.util.Random;

public class Car {
    private static final int MOVABLE_RANDOM_SEED = 10;
    private static final int MOVABLE_DECISION_FACTOR = 4;

    private int currentPosition = 0;

    public int move() {
        if (isMovable()) {
            this.currentPosition++;
        }
        return currentPosition;
    }

    // 자동차 전진 결정 함수
    private boolean isMovable() {
        return new Random().nextInt(MOVABLE_RANDOM_SEED) >= MOVABLE_DECISION_FACTOR;
    }
}
