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
        while (currentRound < roundCount) {
            List<Integer> moveCounts = numberGenerator.generateRandomNumbers(carCount);
            cars.move(moveCounts);
            List<Integer> currentLocations = cars.getCurrentLocations();
            resultView.printEveryLocation(currentLocations);
            currentRound++;
        }
    }
}
