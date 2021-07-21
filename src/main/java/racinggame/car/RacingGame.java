package racinggame.car;

import racinggame.factory.MovingFactory;
import racinggame.strategy.MovingStrategy;
import racinggame.ui.ResultView;

public class RacingGame {

    private final Cars cars;
    private final Count num;

    private RacingGame(Cars cars, Count num) {
        this.cars = cars;
        this.num = num;
    }

    public static RacingGame of(int carNumber, int countNumber) {
        return new RacingGame(Cars.manyOf(Count.of(carNumber)), Count.of(countNumber));
    }

    public ResultView play() {
        MovingStrategy strategy = MovingFactory.movingStrategy();
        int count = num.getCount();
        for (int i = 0; i < count; i++) {
            cars.race(strategy);
        }

        return new ResultView(cars, count);
    }
}
