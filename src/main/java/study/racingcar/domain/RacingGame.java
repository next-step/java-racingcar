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

    public RacingGameResult play(int time) {
        return this.play(new Time(time));
    }

    public RacingGameResult play(Time time) {
        GameEvent gameEvent = new GameEvent();

        for (int i = 0, count = time.getTime(); i < count; i++) {
            gameEvent.add(new Cars(cars));
            cars = gameEvent.getLastEvent();
            cars.move(movableDistance);
        }

        return new RacingGameResult(gameEvent);
    }
}
