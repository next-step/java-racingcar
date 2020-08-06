package racingcar;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingApplication {
    public static void main(String... args) {
        startRacing();
    }

    public static void startRacing() {
        String carList = InputView.inputCars();
        int round = InputView.inputRound();

        Cars cars = new Cars(carList);
        for (int i = 0; i < round; i++) {
            cars.moveCars();
            ResultView.markRacing(cars);
        }

        ResultView.printWinner(cars);
    }
}
