package racingcar;

import racingcar.controller.RacingCar;
import racingcar.view.InputProcessor;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class MainApplication {
    public static void main(String[] args) {
        String carNames = InputProcessor.getCarNamesFromUser();
        String tryCount = InputProcessor.getTryCountsFromUser();

        RacingCar racingCar = RacingCar.ready(InputView.of(carNames, tryCount));
        while (racingCar.isNotEnd()) {
            racingCar.start();
            OutputView.printCurrentPosition(racingCar);
        }

        OutputView.printWinners(racingCar.getWinners());
    }
}