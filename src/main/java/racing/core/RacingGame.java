package racing.core;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public Cars cars;
    public int numberOfTrials;

    public RacingGame(int numberOfCars, int numberOfTrials) {
        this.cars = makeUpEntry(numberOfCars);
        this.numberOfTrials = numberOfTrials;
    }

    public List<Trial> run(MoveStrategy movement) {
        List<Trial> trials = new ArrayList<>();
        for (int i = 0; i < numberOfTrials; i++) {
            trials.add(cars.nextTrial(movement));
        }
        return trials;
    }

    private Cars makeUpEntry(int numberOfCars) {
        List<Car> carList = new ArrayList<>(numberOfCars);
        for (int i = 0; i < numberOfCars; i++) {
            carList.add(new Car());
        }
        return new Cars(carList);
    }
}
