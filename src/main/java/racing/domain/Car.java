package racing.domain;

import racing.Constant;

public class Car {
    private String name;
    private int position;

    public Car(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(Constant.CAR_NAME_BLANK_VALIDATION_ERROR);
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException(Constant.CAR_NAME_LENGTH_VALIDATION_ERROR);
        }

        this.name = name;
        this.position = Constant.START_POSITION;
    }

    public Car(final String name, int position) {
        this.name = name;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return this.name;
    }

    public void move(int number) {
        if (number >= Constant.GO_FORWARD_MIN_VALUE) {
            position++;
        }
    }

    public int max(int other) {
        if (this.position > other) {
            return this.position;
        }
        return other;
    }

    public boolean isMatch(int maxPosition) {
        return this.position == maxPosition;
    }
}
