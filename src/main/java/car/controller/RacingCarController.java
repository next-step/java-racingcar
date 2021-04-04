package car.controller;

import car.domain.RacingCars;
import car.dto.UserInput;
import car.view.InputView;
import car.view.ResultView;

public class RacingCarController {

    public void play(RacingCars racingCars) {
        UserInput input = InputView.receiveInput();

        racingCars.addCars(input.carNameList);

        for (int i = 0; i < input.totalRound; ++i) {
            racingCars.runRound();
            ResultView.printStatus(racingCars);
        }

        ResultView.printWinner(racingCars);
    }
}
