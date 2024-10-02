package step3.model;

public class CarName {
    private static final int MINIMUM_LENGTH = 1;
    private static final int MAXIMUM_LENGTH = 5;
    private static final String BLANK = " ";
    private static final String INVALID_LENGTH_CAR_NAME_ERROR_MESSAGE =
            "자동차 이름의 길이는 " + MINIMUM_LENGTH + " 이상 " + MAXIMUM_LENGTH + " 이하 이어야 합니다.";
    private static final String BLANK_CONTAIN_ERROR_MESSAGE = "자동차 이름에 공백은 포함될 수 없습니다.";

    private final String carName;

    public CarName(final String carName) {
        validateNameLength(carName);
        validateContainBlank(carName);
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    private void validateNameLength(final String carName) {
        if (carName.isEmpty() || MAXIMUM_LENGTH < carName.length()) {
            throw new IllegalArgumentException(INVALID_LENGTH_CAR_NAME_ERROR_MESSAGE);
        }
    }

    private void validateContainBlank(final String carName) {
        if (carName.contains(BLANK)) {
            throw new IllegalArgumentException(BLANK_CONTAIN_ERROR_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CarName carName = (CarName) object;
        return this.carName.equals(carName.carName);
    }

    @Override
    public int hashCode() {
        return carName.hashCode();
    }
}
