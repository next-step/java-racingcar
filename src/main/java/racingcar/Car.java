package racingcar;

import java.util.Random;

public class Car {

    private static final int MAX_RANDOM_BOUND = 10;
    private static final int CAN_MOVE_NUMBER = 4;

    private int position = 0;

    public void move() {
        if (canMove(getRandom())) {
            position += 1;
        }
    }

    public void print() {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
    }

    // TODO: private 메소드 단위 테스트 고민.
    private int getRandom() {
        Random random = new Random();
        return random.nextInt(MAX_RANDOM_BOUND);
    }

    private boolean canMove(int value) {
        return value >= CAN_MOVE_NUMBER;
    }

}
