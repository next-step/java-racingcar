package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final List<Car> cars = new ArrayList<>();
    private final ScoreBoard scoreBoard = new ScoreBoard();
    private final int play;

    public Race(final int numberOfCars, final int numberOfPlays, final MovingRule movingRule) {
        for (int i = 0; i < numberOfCars; i++) {
            this.cars.add(createCar(movingRule));
        }
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
            result.addCarLocation(car.location());
        }
        scoreBoard.addResult(result);
    }

    private Car createCar(MovingRule movingRule) {
        return new Car(movingRule, "쌩썡이");
    }

    public ScoreBoard result() {
        return scoreBoard;
    }
}
