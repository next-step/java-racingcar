package racing.core.domain;

import racing.core.dto.Trial;
import racing.core.patterns.MoveStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Car> participants = Arrays.stream(namesOfCars)
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(participants);
    }

    public List<Car> getWinners() {
        return cars.getWinners();
    }
}
