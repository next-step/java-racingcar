package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final List<Car> cars = new ArrayList<>();
    private final ScoreBoard scoreBoard = new ScoreBoard();
    private final int play;

    public Race(final String[] nameOfCars, final int numberOfPlays, final MovingRule movingRule) {
        for (String nameOfCar : nameOfCars) {
            this.cars.add(createCar(movingRule, nameOfCar));
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

    private Car createCar(MovingRule movingRule, final String carName) {
        return new Car(movingRule, carName);
    }

    public ScoreBoard result() {
        return scoreBoard;
    }
}
