package racingcar;

import util.InputValidator;
import util.InputView;

public class RacingCarGameExecutor {
    public static void main(String[] args) {
        int carCount = getCarCount();
        int tryCount = getTryCount();

        Cars cars = new Cars(carCount);
        cars.move(tryCount);
    }

    public static int getCarCount() {
        int carCount = InputView.getCarCountInput();
        return InputValidator.checkValidCarCount(carCount);
    }

    public static int getTryCount() {
        int tryCount = InputView.getTryCountInput();
        return InputValidator.checkValidTryCount(tryCount);
    }
}
