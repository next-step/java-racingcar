package racing.service;

import org.jetbrains.annotations.NotNull;
import racing.domain.Cars;
import racing.domain.Count;
import racing.domain.MovingStrategy;
import racing.domain.MovingStrategyFactory;
import racing.view.GameResultView;

class RacingGamePlayPipe {
    private final Cars cars;
    private final Count count;

    RacingGamePlayPipe(Cars cars, Count num) {
        this.cars = cars;
        this.count = num;
    }

    public void play() {
        MovingStrategy strategy = getRandomStrategy();
        for (int i = 0; i < count.getCount(); i++) {
            cars.race(strategy);
        }
    }

    public GameResultView result() {
        return new GameResultView(cars, count.getCount());
    }

    @NotNull
    private MovingStrategy getRandomStrategy() {
        return MovingStrategyFactory.getRandomStrategy();
    }
}
