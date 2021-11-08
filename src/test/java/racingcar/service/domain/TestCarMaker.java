package racingcar.service.domain;

import racingcar.service.strategy.RoundRule;

public class TestCarMaker {

    public static Car victory(String name) {
        return createTestCar(name, () -> true);
    }

    public static Car secondPlace(String name) {
        return createTestCar(name, () -> false);
    }

    public static Car createTestCar(String name, RoundRule roundRule) {
        Car car = new Car(name);
        car.startRace(roundRule);
        return car;
    }
}
