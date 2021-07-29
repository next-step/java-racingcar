package racingcar.service;

import racingcar.comparator.PositionComparator;
import racingcar.domain.CarName;
import racingcar.domain.Cars;
import racingcar.domain.Position;
import racingcar.strategy.MovingStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {
    private final Cars cars;
    int raceTrialCount;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public RacingGame(Cars cars, int raceTrialCount) {
        this.cars = cars;
        this.raceTrialCount = raceTrialCount;
    }

    public List<CarName> findWinners() {
        List<Position> lastRecords = cars.getCarsPositions();
        List<CarName> lastGameCarNames = cars.getNames();

        Position winnersPosition = Collections.max(lastRecords, new PositionComparator());

        return IntStream.range(0, lastRecords.size())
                .filter(i -> lastRecords.get(i).compare(winnersPosition))
                .mapToObj(i -> lastGameCarNames.get(i))
                .collect(Collectors.toList());
    }

    public void race(MovingStrategy movingStrategy) {
        cars.move(movingStrategy);
        raceTrialCount--;
    }

    public boolean isEnd() {
        return raceTrialCount == 0 ? true : false;
    }
}
