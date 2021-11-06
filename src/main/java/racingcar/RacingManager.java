package racingcar;

import java.util.List;
import java.util.stream.IntStream;

public class RacingManager {
    int numberOfTrials;
    List<Car> cars;

    RacingManager(int numberOfTrials, List<Car> cars) {
        this.numberOfTrials = numberOfTrials;
        this.cars = cars;
    }

    public void startRacing() {
        IntStream.range(0, numberOfTrials)
                .forEach( number ->
                        progressRacing()
                );
    }

    private void progressRacing() {
        cars.forEach(Car::progressRace);
    }
}
