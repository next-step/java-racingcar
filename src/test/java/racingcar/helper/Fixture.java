package racingcar.helper;

import racingcar.CarRacing;
import racingcar.car.Car;
import racingcar.car.Cars;
import racingcar.param.RacingCarInitParam;
import racingcar.strategy.MoveStrategy;

import java.util.stream.IntStream;

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

    public static CarRacing testCarRacing(int totalRound, int numberOfCars) {
        String[] names = IntStream.range(0, numberOfCars)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        return CarRacing.init(RacingCarInitParam.of(totalRound, names));
    }
}
