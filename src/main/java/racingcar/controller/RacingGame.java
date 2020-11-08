package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarConfiguration;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.List;

public class RacingGame {

    public void run() {
        ResultView resultView = new ResultView();
        resultView.intro();

        InputView inputView = new InputView();
        String enterCars = inputView.getEnterCars();

        List<RacingCar> racingCars = new RacingCarConfiguration(enterCars).getRacingCars();

        resultView.enterCar();

    }


}
