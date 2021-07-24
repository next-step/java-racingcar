package racing.service;

import org.jetbrains.annotations.NotNull;
import racing.domain.*;
import racing.view.GameResultView;

public class RacingGame {

    private final Cars cars;
    private final Count count;

    private RacingGame(Cars cars, Count num) {
        this.cars = cars;
        this.count = num;
    }

    public static RacingGame initialize(Players players, int countNumber) {
        return new RacingGame(new Cars(players), new Count(countNumber));
    }

    public GameResultView play() {
        MovingStrategy strategy = getRandomStrategy();
        int count = this.count.getCount();
        for (int i = 0; i < count; i++) {
            cars.race(strategy);
        }

        return new GameResultView(cars, count);
    }

    @NotNull
    private MovingStrategy getRandomStrategy() {
        return MovingStrategyFactory.getRandomStrategy();
    }

}
