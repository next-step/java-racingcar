package carracing.domain;

import carracing.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<RacingCar> racingCars;
    private TryCount tryCount;

    public RacingGame(List<RacingCar> cars) {
        this(cars, new TryCount(0));
    }

    public RacingGame(String name, int tryCount) {
        this(CarFactory.from(name), new TryCount(tryCount));
    }

    public RacingGame(List<RacingCar> racingCars, TryCount tryCount) {
        this.racingCars = racingCars;
        this.tryCount = tryCount;
    }

    public List<String> findWinners() {
        return findNameByPosition(findMaxPosition());
    }

    private List<String> findNameByPosition(Position maxPosition) {
        List<String> winners = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            if (racingCar.isGreaterThanPosition(maxPosition)) {
                winners.add(racingCar.getName());
            }
        }
        return winners;
    }

    private Position findMaxPosition() {
        Position maxPosition = new Position();
        for (RacingCar racingCar : racingCars) {
            if (racingCar.isGreaterThanPosition(maxPosition)) {
                maxPosition = racingCar.getPosition();
            }
        }
        return maxPosition;
    }

    public void play() {
        for (RacingCar racingCar : racingCars) {
            racingCar.move(RandomUtil.getRandomValue());
        }
    }
}
