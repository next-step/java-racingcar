package racingcar;

public class RacingCarGame {
    public void startGame(NumberBasedCarMover carMover) {
        Cars cars = inputCars();
        TryCount tryCount = inputTryCount();
        game(cars, tryCount, carMover);
        printGameResult(cars);
    }

    private Cars inputCars() {
        return new Cars(InputView.inputCarNames());
    }

    private TryCount inputTryCount() {
        return new TryCount(InputView.inputTryCount());
    }

    private void game(Cars cars, TryCount tryCount, NumberBasedCarMover carMover) {
        int currentTryCount = 0;
        ResultView.printResultMessage();
        while (tryCount.isNotSame(currentTryCount++)) {
            cars.moveAll(carMover);
            ResultView.printCarsPosition(cars.cars());
        }
    }

    private void printGameResult(Cars cars) {
        ResultView.printCarsPosition(cars.cars());
        ResultView.printWinners(cars.winners());
    }
}
