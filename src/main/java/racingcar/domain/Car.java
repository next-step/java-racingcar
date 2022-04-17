package racingcar.domain;

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

    public void go() {
         currentPosition.append(LINE);
    }
}
