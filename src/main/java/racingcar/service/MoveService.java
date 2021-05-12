package racingcar.service;

import java.util.Random;

public class MoveService {
    private static final int RANDOM_NUMBER = 10;
    private static final int MOVABLE_NUMBER = 4;

    public String isMove() {
        Random random = new Random();
        int number = random.nextInt(RANDOM_NUMBER);
        if (number >= MOVABLE_NUMBER) {
            return "1";
        }
        return "0";
    }

    public boolean isMovable() {
        return new Random().nextInt(10) >= 4;
    }
}
