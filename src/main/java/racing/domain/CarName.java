package racing.domain;

public class CarName {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String INVALID_CAR_NAME_LENGTH_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다.";

    private final String carName;

    public CarName(String carName) {
        validate(carName);
        this.carName = carName;
    }

    private void validate(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new RuntimeException(INVALID_CAR_NAME_LENGTH_MESSAGE);
        }
    }

    public String getCarName() {
        return carName;
    }
}
