package racingcar;

import racingcar.controller.RacingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class MainApplication {
    public static void main(String[] args) {
        RandomNumGenerator randomNumGenerator = new RandomNumGenerator();

        String carNames = InputView.getCarNamesFromUser();
        String tryCounts = InputView.getTryCountsFromUser();

        RacingCar racingCar = new RacingCar(InputView.of(carNames, tryCounts));
        racingCar.startGame(randomNumGenerator);

        OutputView.print(racingCar);
    }
}