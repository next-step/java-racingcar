package racingcar;

import racingcar.domain.CarGroups;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingApplication {
    public static void main(String... args) {
        startRacing();
    }

    public static void startRacing() {
        int carCount = InputView.inputCarCount();
        int round = InputView.inputRound();

        CarGroups cars = new CarGroups(carCount);
        for (int i = 0; i < round; i++) {
            cars.moveCars();
            ResultView.markMove(cars.getCars());
        }
    }
}
