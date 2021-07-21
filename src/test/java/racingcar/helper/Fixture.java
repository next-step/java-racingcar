package racingcar.helper;

import racingcar.car.Car;
import racingcar.car.Cars;
import racingcar.strategy.MoveStrategy;

public class Fixture {
    public static final MoveStrategy ALWAYS_MOVE_STRATEGY = () -> true;
    public static final MoveStrategy NEVER_MOVE_STRATEGY = () -> false;

    private Fixture() {}

    public static Car testCar() {
        return Car.from("TEST");
    }

    public static Cars testCars() {
        return Cars.init("nok", "cha", "x", "test", "cars");
    }
}
