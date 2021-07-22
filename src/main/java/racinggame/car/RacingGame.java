package racinggame.car;

import racinggame.factory.MovingFactory;
import racinggame.strategy.MovingStrategy;
import racinggame.ui.ResultView;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RacingGame {

    private static final String CAR_NAME_SPLITTER = ",";
    private final Cars cars;
    private final Count num;

    private RacingGame(String carNames, Count num) {
        this.cars = initCars(carNames);
        this.num = num;
    }

    public static RacingGame of(String carNames, int countNumber) {
        return new RacingGame(carNames, Count.of(countNumber));
    }

    public ResultView play() {
        MovingStrategy strategy = MovingFactory.movingStrategy();
        int count = num.initValue();
        for (int i = 0; i < count; i++) {
            cars.race(strategy);
        }

        return new ResultView(cars, count);
    }

    private Cars initCars(String carNames) {
        return Arrays.stream(carNames.split(CAR_NAME_SPLITTER))
                .map(name -> new Car(CarName.of(name)))
                .collect(Collectors
                        .collectingAndThen(Collectors.toList(), Cars::manyOf));
    }
}
