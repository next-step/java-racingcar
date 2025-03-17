package racingcar;

import java.util.List;

import racingcar.ui.RacingCarInput;
import racingcar.ui.RacingCarInputView;
import racingcar.ui.RacingCarResultView;

public class RacingCarGame {

    public static void start() {
        RacingCarInput input = RacingCarInputView.show();
        List<RacingCar> racingCars = RacingCar.createRacingCars(input.getCarCount());
        RacingCarResultView.view(racingCars, input.getTryCount());
    }

}
