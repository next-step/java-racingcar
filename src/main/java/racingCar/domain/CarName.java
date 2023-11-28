package racingCar.domain;

public class CarName {
    private static final int MAX_NAME_LENGTH = 5;
    private String value;

    public CarName(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String carName) {
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("Car name cannot be longer than 5 char");
        }
    }

    public String getValue() {
        return this.value;
    }

    public boolean isEqual(String carName) {
        return this.value.equals(carName);
    }
}
