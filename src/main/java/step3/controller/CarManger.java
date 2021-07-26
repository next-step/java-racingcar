package step3.controller;

import step3.model.Car;

public class CarManger {
    private static final int MIN_ROUND = 0;
    private static final int MAX_ROUND = 10;
    private static final String CAR_ERROR_MESSAGE = "자동차 대수는 1대 이상이어야 합니다.";
    Car car;

    public CarManger() {
        this.car = new Car();
    }

    public void moveForward() {
        car.position++;
    }

    public static void inputCarCheck(int round) {
        if (round <= MIN_ROUND) {
            throw new IllegalArgumentException(CAR_ERROR_MESSAGE);
        }
    }
}
