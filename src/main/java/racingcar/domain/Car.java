package racingcar.domain;

import racingcar.service.NumberStrategy;
import racingcar.service.RandomMoveStrategy;

public class Car {
    private static final String LINE = "-";
    private final StringBuilder currentPosition;

    public Car() {
        currentPosition = new StringBuilder();
    }

    public String getCurrentPosition() {
        return toString(currentPosition);
    }

    private String toString(StringBuilder currentPosition) {
        return currentPosition.toString();
    }

    private void go() {
         currentPosition.append(LINE);
    }

    private void stop() {
        return;
    }

    public void move(NumberStrategy randomMoveStrategy) {
        if(randomMoveStrategy.isMovable())  go();
    }
}
