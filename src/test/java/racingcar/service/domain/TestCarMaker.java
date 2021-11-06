package racingcar.service.domain;

import racingcar.service.domain.strategy.RandomResultFalse;
import racingcar.service.domain.strategy.RandomResultTrue;
import racingcar.service.strategy.RoundRule;

public class TestCarMaker {

    public static Car victory(String name) {
        return createTestCar(name, new RandomResultTrue());
    }

    public static Car secondPlace(String name) {
        return createTestCar(name, new RandomResultFalse());
    }

    public static Car createTestCar(String name, RoundRule roundRule) {
        Car car = new Car(name);
        car.race(roundRule);
        return car;
    }
}
