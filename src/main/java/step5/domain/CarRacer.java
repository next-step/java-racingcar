package step5.domain;

import step5.util.RandomGame;

public class CarRacer {
    private static final String VALID_CAR_ERROR = "자동차 이름의 최대 길이는 5글자입니다.";
    private static final int INIT_START_POSITION = 1;
    private Car car;
    private static RandomGame randomGame = new RandomGame();

    public CarRacer(String carName) {
        checkValidCar(carName);
        getNewCar(carName);

    }
    private void getNewCar(String carName) {
        car = new Car(INIT_START_POSITION, carName);
    }

    private void checkValidCar(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(VALID_CAR_ERROR);
        }
    }

    public CarRacer canIGo() {
        if (randomGame.throwDice()) {
            car.moveForward();
        }
        return this;
    }

    public int getCurrPosition() {
        return car.getPosition();
    }

    public String getCarName() {
        return car.getName();
    }
}
