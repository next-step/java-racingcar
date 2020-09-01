package racing.core;

import racing.core.domain.Car;
import racing.core.domain.Cars;
import racing.core.dto.Trial;
import racing.core.patterns.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public Cars cars;
    public final int numberOfTrials;

    public RacingGame(String[] namesOfCars, int numberOfTrials) {
        this.cars = makeUpEntry(namesOfCars);
        this.numberOfTrials = numberOfTrials;
    }

    public List<Trial> run(MoveStrategy movement) {
        List<Trial> trials = new ArrayList<>();
        for (int i = 0; i < numberOfTrials; i++) {
            cars = cars.runTrial(movement);
            trials.add(new Trial(cars));
        }
        return trials;
    }

    private Cars makeUpEntry(String[] namesOfCars) {
        return Cars.of(namesOfCars);
    }

    public List<Car> getWinners() {
        return cars.getWinners();
    }
}
