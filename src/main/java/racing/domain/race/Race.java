package racing.domain.race;

import racing.domain.car.Car;

import java.util.List;

public class Race {

    private final List<Car> cars;
    private final ScoreBoard scoreBoard = new ScoreBoard();
    private final int play;

    public Race(final List<Car> cars, final int numberOfPlays) {
        this.cars = cars;
        this.play = numberOfPlays;
    }

    public void play() {
        for (int i = 0; i < play; i++) {
            race();
        }
    }

    private void race() {
        RaceResult result = new RaceResult();
        for (Car car : cars) {
            car.move();
            result.addRecord(car);
        }
        scoreBoard.addResult(result);
    }

    public ScoreBoard result() {
        return scoreBoard;
    }
}
