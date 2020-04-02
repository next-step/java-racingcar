package study.racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private Cars cars;
    private MovableDistance movableDistance;

    public RacingGame(Cars cars,
                      MovableDistance movableDistance) {
        this.cars = cars;
        this.movableDistance = movableDistance;
    }

    public RacingGame(List<String> carNames, MovableDistance movableDistance) {
        this(Cars.valueOf(carNames), movableDistance);
    }

    public RacingGameResult play(int time) {
        return this.play(new Time(time));
    }

    public RacingGameResult play(Time time) {
        List<Cars> results = new ArrayList<>();

        for (int i = 0, count = time.getTime(); i < count; i++) {
            cars.move(movableDistance);
            results.add(new Cars(cars));
        }

        return new RacingGameResult(results);
    }
}
