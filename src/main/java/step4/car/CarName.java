package step4.car;

public class CarName {

    private final String value;
    private static final int CAR_NAME_LENGTH_LIMIT = 5;

    public CarName(String carName) {
        validateCarName(carName);
        this.value = carName;
    }

    private void validateCarName(String carName) {
        if (isOverCarNameLengthLimit(carName))
            throw new IllegalArgumentException("carName's length must be less than five length");
    }

    private boolean isOverCarNameLengthLimit(String carName) {
        return carName.length() > CAR_NAME_LENGTH_LIMIT;
    }

    public String getValue() {
        return value;
    }
}
