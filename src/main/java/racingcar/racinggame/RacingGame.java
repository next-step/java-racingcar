package racingcar.racinggame;

import racingcar.domain.Car.Cars;
import racingcar.dto.Result;
import racingcar.dto.Winner;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final List<List<Result>> eachResults = new ArrayList<>();
    private final Cars cars;
    private final Count count;

    public RacingGame(final Cars cars, final String count) {
        this.cars = cars;
        this.count = new Count(count.trim());
    }

    public void play() {
        while (count.isRunning()) {
            cars.move();
            eachResults.add(getResult());
            count.run();
        }
    }

    public List<List<Result>> getEachResults() {
        return eachResults;
    }

    public List<Result> getResult() {
        return cars.findAll();
    }

    public List<Winner> getWinners() {
        return cars.findWinners();
    }
}
