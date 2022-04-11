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

        for (int i = 0; i < roundCount; i++) {
            List<Integer> moveCounts = numberGenerator.generateRandomNumbers(carCount);
            List<Integer> currentLocations = cars.move(moveCounts);
            resultView.printEveryLocation(currentLocations);
        }
    }
}
