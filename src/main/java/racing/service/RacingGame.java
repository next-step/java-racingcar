package racing.service;

import racing.domain.Cars;
import racing.domain.Count;
import racing.domain.MovingStrategyFactory;
import racing.domain.MovingStrategy;
import racing.view.GameResultView;

public class RacingGame {

    private final Cars cars;
    private final Count count;

    private RacingGame(Cars cars, Count num) {
        this.cars = cars;
        this.count = num;
    }

    public static RacingGame initialize(int carNumber, int countNumber) {
        return new RacingGame(new Cars(new Count(carNumber)), new Count(countNumber));
    }

    public GameResultView play() {
        MovingStrategy strategy = MovingStrategyFactory.getStrategy();
        int count = this.count.getCount();
        for (int i = 0; i < count; i++) {
            cars.race(strategy);
        }

        return new GameResultView(cars, count);
    }

}
