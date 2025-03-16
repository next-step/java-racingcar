package racing;

import racing.car.Car;
import racing.car.Cars;
import racing.ui.InputView;
import racing.ui.ResultView;

import java.util.List;

public class RacingGame {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        String[] carNames = InputView.inputCarNames();
        int tryCount = InputView.inputTryCount();

        Cars cars = new Cars(carNames);

        cars.race(tryCount);
        List<Car> winners = cars.getWinners();
        ResultView.printWinners(winners);
    }
}
