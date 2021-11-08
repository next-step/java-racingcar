package racingcar;

import util.RandomGenerator;

import java.util.List;
import java.util.stream.IntStream;

public class RacingManager {
    private final int INCREMNET_OF_ROUNDS = 1;
    private final int numberOfTrials;
    private final List<Car> cars;

    RacingManager(int numberOfTrials, List<Car> cars) {
        this.numberOfTrials = numberOfTrials;
        this.cars = cars;
    }

    public int startRacing(OutputView outputView) {
        outputView.showOutputMessage();

        return IntStream.rangeClosed(1, numberOfTrials)
                .reduce( 0, (countOfRounds, roundNumber) -> {
                    outputView.showStartOfRound(roundNumber);
                    progressEntireRound(outputView);
                    outputView.showEndOfRound(roundNumber);

                    return countOfRounds + INCREMNET_OF_ROUNDS;
                });
    }

    private void progressEntireRound(OutputView outputView) {
        cars.forEach( car -> progressRound(car, outputView));
    }

    private void progressRound(Car car, OutputView outputView) {
        int randomNumber = RandomGenerator.generateNumberBetweenZeroToNine();

        int distance = car.runOrStop(randomNumber);
        outputView.showDistanceOfCar(distance);
    }
}
