package racingcar;

import java.util.Objects;
import java.util.Random;

public class Car {
    private static final int START_POSITION = 0;
    private static final int DEFAULT_STOP_COUNT = 0;
    private static final int DEFAULT_MOVE = 1;
    private static final int DEFAULT_STOP = 1;
    private static final int BOUND = 10;
    private static final int CONDITION = 4;
    private static final Random random = new Random();

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && stopCount == car.stopCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, stopCount);
    }
}
