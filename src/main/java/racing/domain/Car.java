package racing.domain;

import java.text.MessageFormat;

public class Car {
    private static final int MIN_RESULT = 0;
    private final static int MAX_RESULT = 9;
    private final static int RUN_CRITERIA_MIN_RESULT = 4;

    private final int id;
    private int location;

    public Car(final int id) {
        this.id = id;
        this.location = 0;
    }

    public int getId() {
        return id;
    }

    public int getLocation() {
        return location;
    }

    public void run(final int result) {
        if (result < MIN_RESULT || result > MAX_RESULT) {
            throw new IllegalArgumentException(MessageFormat.format("{0} ~ {1}사이의 결과값이어야 합니다.", MIN_RESULT, MAX_RESULT));
        }

        if (result >= RUN_CRITERIA_MIN_RESULT) {
            location++;
        }
    }

    @Override
    public String toString() {
        return "Car{" +
               "id=" + id +
               ", location=" + location +
               '}';
    }
}
