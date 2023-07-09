package racingcar.domain.racinggame;

import racingcar.domain.Car.Cars;
import racingcar.dto.Results;
import racingcar.dto.Winners;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final List<Results> totalResult = new ArrayList<>();
    private final Cars cars;
    private final Count count;

    public RacingGame(final Cars cars, final String count) {
        this.cars = cars;
        this.count = new Count(count.trim());
    }

    public void play() {
        while (count.isRunning()) {
            cars.move();
            totalResult.add(getResults());
            count.decrease();
        }
    }

    public List<Results> getTotalResult() {
        return List.copyOf(totalResult);
    }

    public Results getResults() {
        return cars.findAll();
    }

    public Winners getWinners() {
        return cars.findWinners();
    }
}
