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
        String[] carNames = inputView.inputCarNames();
        int roundCount = inputView.inputRoundCount();

        Cars cars = Cars.generateCars(carNames);

        int currentRound = 0;
        while (inProgress(roundCount, currentRound)) {
            moveCars(carNames.length, cars);
            printResult(cars);
            currentRound++;
        }
    }

    private void printResult(Cars cars) {
        resultView.printEveryLocation(cars.getCarList());
    }

    private void moveCars(int carCount, Cars cars) {
        List<Integer> moveCounts = numberGenerator.generateRandomNumbers(carCount);
        cars.move(moveCounts);
    }

    private boolean inProgress(int roundCount, int currentRound) {
        return currentRound < roundCount;
    }
}
