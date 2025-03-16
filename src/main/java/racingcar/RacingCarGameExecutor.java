package racingcar;

import util.InputValidator;
import util.InputView;
import util.ResultView;

import java.util.List;

public class RacingCarGameExecutor {
    public static void main(String[] args) {
        int carCount = getCarCount();
        int tryCount = getTryCount();

        List<Car> cars = CarExecutor.initializeCars(carCount);
        moveCar(cars, tryCount);
    }

    public static int getCarCount() {
        int carCount = InputView.getCarCountInput();
        return InputValidator.checkValidCarCount(carCount);
    }

    public static int getTryCount() {
        int tryCount = InputView.getTryCountInput();
        return InputValidator.checkValidTryCount(tryCount);
    }

    public static void getCarResults(List<Car> car) {
        ResultView.showCarGameResult(car);
    }

    public static void moveCar(List<Car> cars, int tryCount) {
        ResultView.showResultMessage();
        for (int index = 0; index < tryCount; index++) {
            moveCarPerRound(cars);
        }
    }

    public static void moveCarPerRound(List<Car> cars) {
        for (Car car : cars) {
            CarExecutor.move(car);
        }
        getCarResults(cars);
    }
}
