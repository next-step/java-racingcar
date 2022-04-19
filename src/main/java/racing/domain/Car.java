package racing.domain;

import java.text.MessageFormat;

public class Car {
    private static final int MIN_RESULT = 0;
    private static final int MAX_RESULT = 9;
    private static final int RUN_CRITERIA_MIN_RESULT = 4;

    private Location location;

    public Car() {
        this.location = new Location();
    }

    public Location getLocation() {
        return location;
    }

    public void run(final int result) {
        if (result < MIN_RESULT || result > MAX_RESULT) {
            throw new IllegalArgumentException(MessageFormat.format("{0} ~ {1}사이의 결과값이어야 합니다.", MIN_RESULT, MAX_RESULT));
        }

        if (result >= RUN_CRITERIA_MIN_RESULT) {
            location.forward();
        }
    }

    @Override
    public String toString() {
        return "Car{" +
               "location=" + location +
               '}';
    }
}
