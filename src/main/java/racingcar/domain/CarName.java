package racingcar.domain;

public class CarName {

    private final String carName;

    private static final int MAX_CAR_NAME_LENGTH_INCLUSIVE = 5;

    public CarName(final String carName) {
        validateCarName(carName);
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    private void validateCarName(final String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH_INCLUSIVE) {
            throw new IllegalArgumentException("자동차의 이름은 5글자를 넘을 수 없습니다.");
        }
    }

}
