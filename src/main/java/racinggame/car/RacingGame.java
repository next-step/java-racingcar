package racinggame.car;

import racinggame.factory.MovingFactory;
import racinggame.strategy.MovingStrategy;
import racinggame.ui.ResultView;

import java.util.ArrayList;
import java.util.List;

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
        String[] names = carNames.split(CAR_NAME_SPLITTER);
        List<Car> list = new ArrayList<>();
        for (String name : names) {
            list.add(new Car(CarName.of(name)));
        }

        return Cars.manyOf(list);
    }
}
