package racingcar;

import util.InputValidator;
import util.InputView;
import util.ResultView;

import java.util.List;

public class RacingCarGameExecutor {
    public static void main(String[] args) {
        String[] carNames = InputView.getCarNames();
        int tryCount = getTryCount();

        Cars cars = new Cars(carNames);
        cars.move(tryCount);
        List<Car> winners = cars.getWinners();
        ResultView.showCarGameWinners(winners);
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
