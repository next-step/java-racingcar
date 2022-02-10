package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final TryCount tryCount;
    private MoveStrategy moveStrategy;

    public RacingGame(Cars cars, int tryCount) {
        this.cars = cars;
        this.tryCount = new TryCount(tryCount);
    }

    public RacingGame(Cars cars, int tryCount, MoveStrategy moveStrategy) {
        this(cars, tryCount);
        this.moveStrategy = moveStrategy;
    }

    public RaceResults startRace() {
        List<List<Car>> totalResult = new ArrayList<>();
        while (tryCount.isPlaying()) {
            List<Car> raceResultByRound = saveEachRoundResult(cars.moveCars(moveStrategy));
            totalResult.add(raceResultByRound);
            tryCount.decreaseTryCount();
        }
        System.out.println(totalResult.get(0).get(0));
        System.out.println(totalResult.get(1).get(0));
        return new RaceResults(totalResult);
    }

    private List<Car> saveEachRoundResult(List<Car> raceResult) {
        List<Car> raceResultByRound = new ArrayList<>();
        for (Car car : raceResult) {
            raceResultByRound.add(new Car(car.getCarName(), car.getPosition()));
        }
        return raceResultByRound;
    }
}
