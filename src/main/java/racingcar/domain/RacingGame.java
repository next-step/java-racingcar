package racingcar.domain;

import racingcar.strategy.MoveStrategy;

public class RacingGame {
    private static final String DELIMITER = ",";
    private int tryCount;

    private Cars cars;

    public RacingGame(String carsName, int tryCount) {
        this.tryCount = tryCount;
        this.cars = initRacing(carsName);
    }

    private Cars initRacing(String carsName) {
        cars = new Cars();
        isNullOrEmpty(carsName);
        String[] carNames = nameSplit(carsName);
        for (int i = 0; i < carNames.length; i++) {
            checkNameLength(carNames[i]);
            cars.addCar(new Car(carNames[i]));
        }
        return cars;
    }

    private String[] nameSplit(String carsName) {
        String[] carNames = carsName.split(DELIMITER);
        return carNames;
    }

    private void checkNameLength(String carName) {
        if (carName.length() > 5) throw new RuntimeException("자동차 이름은 5자를 초과할 수 없다.");
    }

    public boolean isEndGame() {
        return tryCount > 0 ? false : true;
    }

    public Cars start(MoveStrategy moveStrategy) {
        tryCount--;
        cars.carList().forEach(car -> car.moveForward(moveStrategy.randomNumber()));
        return cars;
    }

    public Cars cars() {
        return cars;
    }

    private boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
