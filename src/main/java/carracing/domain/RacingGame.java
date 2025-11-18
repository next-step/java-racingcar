package carracing.domain;

import carracing.util.RandomUtil;

import java.util.List;

public class RacingGame {
    private List<RacingCar> racingCars;
    private TryCount tryCount;

    public RacingGame(String name, int tryCount) {
        this(CarFactory.from(name), new TryCount(tryCount));
    }

    public RacingGame(List<RacingCar> racingCars, TryCount tryCount) {
        this.racingCars = racingCars;
        this.tryCount = tryCount;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public RacingResult play() {
        for (RacingCar racingCar : racingCars) {
            racingCar.move(RandomUtil.getRandomValue());
        }
        tryCount = tryCount.consume();

        return new RacingResult(racingCars);
    }

    public boolean isEnd() {
        return !tryCount.countOver();
    }
}
