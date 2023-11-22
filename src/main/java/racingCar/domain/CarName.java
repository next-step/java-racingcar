package racingCar.domain;

public class CarName {
    private String value;

    public CarName(String value) {
        if (isValid(value)) {
            this.value = value;
        }
    }

    private boolean isValid(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("Car name cannot be longer than 5 char");
        }
        return Boolean.TRUE;
    }

    public String getValue() {
        return this.value;
    }

    public boolean isEqual(String carName) {
        return this.value.equals(carName);
    }
}
