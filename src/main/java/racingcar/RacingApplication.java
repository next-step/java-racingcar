package racingcar;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingApplication {
    public static void main(String... args) {
        startRacing();
    }

    public static void startRacing() {
        int carCount = InputView.inputCarCount();
        int round = InputView.inputRound();

        Cars cars = new Cars(carCount);
        for (int i = 0; i < round; i++) {
            cars.moveAll();
            ResultView.markMove(cars.getCarList());
        }
    }
}
