package racingcar;

import java.util.Random;

public class Car {
    public static final int START_POSITION = 0;
    public static final int DEFAULT_STOP_COUNT = 0;
    public static final int DEFAULT_MOVE = 1;
    public static final int DEFAULT_STOP = 1;
    public static final int BOUND = 10;
    public static final int CONDITION = 4;
    public static final Random random = new Random();

    private int position = START_POSITION;
    private int stopCount = DEFAULT_STOP_COUNT;

    public void tryMove(int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            moveOrStop();
        }
    }

    private void moveOrStop() {
        if (checkCondition()) {
            move();
            return;
        }
        stop();
    }

    private boolean checkCondition() {
        return randomNumber() >= CONDITION;
    }

    private int randomNumber() {
        return random.nextInt(BOUND);
    }

    private void move() {
        this.position += DEFAULT_MOVE;
    }

    private void stop() {
        stopCount += DEFAULT_STOP;
    }

    public int getPosition() {
        return position;
    }

    public int getTotalTryCount() {
        return this.position + stopCount;
    }
}
