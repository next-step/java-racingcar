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

        printLocations(carNames, roundCount, cars);
        printWinners(cars);
    }

    private void printLocations(String[] carNames, int roundCount, Cars cars) {
        int currentRound = 0;
        while (inProgress(roundCount, currentRound)) {
            moveCars(carNames.length, cars);
            printResult(cars);
            currentRound++;
        }
    }

    private void printWinners(Cars cars) {
        resultView.printWinners(cars);
    }

    private void printResult(Cars cars) {
        List<Car> carList = cars.getCarList();
        resultView.printEveryLocation(carList);
    }

    private void moveCars(int carCount, Cars cars) {
        List<Integer> moveCounts = numberGenerator.generateRandomNumbers(carCount);
        cars.move(moveCounts);
    }

    private boolean inProgress(int roundCount, int currentRound) {
        return currentRound < roundCount;
    }
}
