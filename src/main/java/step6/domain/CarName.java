package step6.domain;

public class CarName {
    private static final String MAX_CARNAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다.";
    private static final int MAX_CARNAME_LEGNTH = 5;

    private final String carName;

    public CarName(String carName) {
        validCarName(carName);
        this.carName = carName;
    }

    private void validCarName(String carName) {
        if (carName.length() > MAX_CARNAME_LEGNTH) {
            throw new IllegalArgumentException(MAX_CARNAME_LENGTH_ERROR_MESSAGE);
        }
    }
}
