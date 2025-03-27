package racingcar.model;

import static racingcar.message.ErrorMessage.INVALID_CAR_NAME_LENGTH;

public class CarName {

    private final String name;

    private static final int MAXIMUM_NAME_LENGTH = 5;

    public CarName(String value) {
        validate(value);
        this.name = value;
    }

    private void validate(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH);
        }

        if (value.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarName)) return false;
        CarName carName = (CarName) o;
        return name.equals(carName.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
