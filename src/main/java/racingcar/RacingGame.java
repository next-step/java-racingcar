package racingcar;

import java.util.List;
import java.util.stream.IntStream;

public class RacingGame {
    public static void run() {
        InputView inputView = new ConsoleInputView();

        int numberOfCars = inputView.getNumberOfCars();
        int numberOfTrials = inputView.getNumberOfTrials();

        CarFactory carFactory = new CarFactory(numberOfCars);
        List<Car> cars = carFactory.buildCars();

        OutputView outputView = new ConsoleOutputView();

        RacingManager racingManager = new RacingManager(cars);

        IntStream.rangeClosed(1, numberOfTrials)
                .forEach(roundNumber -> {
                    outputView.showStartOfRound(roundNumber);
                    List<Integer> progressOfCars = racingManager.progressRound();
                    outputView.showRacing(progressOfCars);
                    outputView.showEndOfRound(roundNumber);
                });
    }
}
