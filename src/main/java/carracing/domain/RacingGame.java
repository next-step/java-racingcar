package carracing.domain;

import carracing.util.RandomUtil;

import java.util.List;

public class RacingGame {
    private RacingCars racingCars;
    private TryCount tryCount;

    public RacingGame(String name, int tryCount) {
        this(CarFactory.from(name), new TryCount(tryCount));
    }

    public RacingGame(List<RacingCar> racingCars, TryCount tryCount) {
        this(new RacingCars(racingCars), tryCount);
    }

    public RacingGame(RacingCars racingCars, TryCount tryCount) {
        this.racingCars = racingCars;
        this.tryCount = tryCount;
    }

    public RacingResult play(NumberGenerator generator) {
        racingCars.moveAll(generator);
        tryCount = tryCount.consume();

        return new RacingResult(racingCars.racingCars());
    }

    public boolean isEnd() {
        return !tryCount.countOver();
    }
}
