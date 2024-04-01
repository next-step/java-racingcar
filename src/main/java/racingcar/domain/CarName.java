package racingcar.domain;

public class CarName {
    private static int MAX_CAR_NAME = 5;
    private String carName;

    public CarName(String carName) {
        if (carName.length() > MAX_CAR_NAME) {
            throw new IllegalArgumentException("자동차 이름 길이 초과 (최대 5자)");
        }
        this.carName = carName;
    }

    @Override
    public String toString() {
        return carName;
    }
}
