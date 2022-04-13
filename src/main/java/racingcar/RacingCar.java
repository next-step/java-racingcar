package racingcar;

import java.util.List;

public class RacingCar {
    private final InputView inputView;
    private final NumberGenerator numberGenerator;
    private final ResultView resultView;

    public RacingCar(InputView inputView, NumberGenerator numberGenerator, ResultView resultView) {
        this.inputView = inputView;
        this.numberGenerator = numberGenerator;
        this.resultView = resultView;
    }

    public void run() {
        int carCount = inputView.inputCarCount();
        int roundCount = inputView.inputRoundCount();

        Cars cars = Cars.generateCars(carCount);

        int currentRound = 0;
        while (inProgress(roundCount, currentRound)) {
            moveCars(carCount, cars);
            printResult(cars);
            currentRound++;
        }
    }

    private void printResult(Cars cars) {
        List<Integer> currentLocations = cars.getCurrentLocations();
        resultView.printEveryLocation(currentLocations);
    }

    private void moveCars(int carCount, Cars cars) {
        List<Integer> moveCounts = numberGenerator.generateRandomNumbers(carCount);
        cars.move(moveCounts);
    }

    private boolean inProgress(int roundCount, int currentRound) {
        return currentRound < roundCount;
    }
}
