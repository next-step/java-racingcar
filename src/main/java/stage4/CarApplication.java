package stage4;

import java.util.List;

public class CarApplication {
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();
    private static final CarService carService = new CarService();

    public static void main(String[] args) {
        final InputValue inputValue = inputView.input();

        final String[] carNames = inputValue.getCarNames();
        final int numberOfTries = inputValue.getTryNum();

        final List<ResultValue> resultValues = carService.startRace(carNames, numberOfTries);

        final int numberOfCars = carNames.length;
        resultView.printResult(numberOfCars, resultValues);
    }
}
