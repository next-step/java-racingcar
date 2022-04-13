package racingcar;

public class CarName {
    private static final int CAR_NAME_SIZE = 5;
    private final String carName;

    public CarName(String carName) {
        validate(carName);
        this.carName = carName;
    }

    private void validate(String carName) {
        if (carName.length() > CAR_NAME_SIZE) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        return carName;
    }
}
