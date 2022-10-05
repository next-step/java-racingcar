package racingcar.domain;

public class CarName {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private final String carName;

    public CarName(String carName) {
        carName = removeSpace(carName);
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new RuntimeException("자동차 이름 " + carName + "은 5자를 초과할 수 없습니다");
        }
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    private static String removeSpace(String carName) {
        return carName.replaceAll("\\s", "");
    }
}
