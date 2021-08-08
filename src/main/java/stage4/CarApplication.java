package stage4;

import java.util.List;

public class CarApplication {
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();
    private static final CarService carService = new CarService();

    private static final int MAX_RETRY = 3;

    public static void main(String[] args) {
        final InputValue inputValue = retryInput();

        final String[] carNames = inputValue.getCarNames();
        final int numberOfTries = inputValue.getTryNum();

        final List<ResultValue> resultValues = carService.startRace(carNames, numberOfTries);

        final int numberOfCars = carNames.length;
        resultView.printResult(numberOfCars, resultValues);
    }

    private static InputValue retryInput() {
        int maxRetry = MAX_RETRY;
        while (true) {
            try {
                final InputValue inputValue = inputView.input();
                return inputValue;
            } catch (TooLongCarNameException exception) {
                exception.printStackTrace();
                System.out.println();
                maxRetry--;
                if (maxRetry == 0) throw new RuntimeException("최대 입력 횟수를 초과하여 종료됩니다.");
            }
        }
    }
}
