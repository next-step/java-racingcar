package racing.core.domain;

import racing.core.dto.Trial;
import racing.core.patterns.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public Cars cars;
    public int numberOfTrials;

    public RacingGame(String[] namesOfCars, int numberOfTrials) {
        this.cars = makeUpEntry(namesOfCars);
        this.numberOfTrials = numberOfTrials;
    }

    public List<Trial> run(MoveStrategy movement) {
        List<Trial> trials = new ArrayList<>();
        for (int i = 0; i < numberOfTrials; i++) {
            trials.add(cars.nextTrial(movement));
        }
        return trials;
    }

    private Cars makeUpEntry(String[] namesOfCars) {
        List<Car> carList = new ArrayList<>(namesOfCars.length);
        for (String eachName : namesOfCars) {
            carList.add(new Car(eachName));
        }
        return new Cars(carList);
    }

    public List<String> getNamesOfWinners() {
        return cars.getNamesOfWinners();
    }
}
