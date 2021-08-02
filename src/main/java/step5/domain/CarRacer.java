package step5.domain;

public class CarRacer {
    static final String VALID_CAR_ERROR = "자동차 이름의 최대 길이는 5글자입니다.";
    static final int INIT_START_POSITION = 1;
    static Car car;
    public CarRacer(String carName) {
        checkValidCar(carName);
        car = new Car(INIT_START_POSITION);
    }

    private void checkValidCar(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(VALID_CAR_ERROR);
        }
    }
}
