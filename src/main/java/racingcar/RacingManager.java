package racingcar;

import util.RandomGenerator;

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
                    outputView.showStartOfRound(number);
                    progressEntireRound(outputView);
                    outputView.showEndOfRound(number);
                });
    }

    private void progressRound(Car car, OutputView outputView) {
        int randomNumber = RandomGenerator.generateNumberBetweenZeroToNine();

        int distance = car.runOrStop(randomNumber);
        outputView.showDistanceOfCar(distance);
    }

    private void progressEntireRound(OutputView outputView) {
        cars.forEach( car -> progressRound(car, outputView));
    }
}
