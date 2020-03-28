package study.racingcar.domain;

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
        this(new Cars(carNames), movableDistance);
    }

    public RacingGameResult play(Time time) {
        RacingGameResult racingGameResult = new RacingGameResult();

        for (int i = 0, count = time.getTime(); i < count; i++) {
            Cars event = move();
            racingGameResult.addGameEvent(event);
            cars = event;
        }

        return racingGameResult;
    }

    public Cars move() {
        Cars event = new Cars();

        for (Car car : cars) {
            car.move(movableDistance.getDistance());
            event.add(car.clone());
        }

        return event;
    }
}
