package racingcar;

import java.util.List;
import java.util.stream.IntStream;

public class RacingManager {
    private final int numberOfTrials;
    private final List<Car> cars;

    RacingManager(int numberOfTrials, List<Car> cars) {
        this.numberOfTrials = numberOfTrials;
        this.cars = cars;
    }

    public void startRacing(OutputView outputView) {
        outputView.showOutputMessage();
        IntStream.rangeClosed(1, numberOfTrials)
                .forEach( number -> {
                    progressRacing();
                    outputView.showRound(number);
                    outputView.showOutput(cars);
                });
    }

    private void progressRacing() {
        cars.forEach(Car::progressRace);
    }
}
