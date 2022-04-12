package racingCar;

import racingCar.view.InputViewRacingCar;
import racingCar.view.ResultViewRacingCar;

public class RacingCarGame {

    public RacingCarGame() {
    }

    public void start() {
        InputViewRacingCar.inputRacingData();
        ResultViewRacingCar.resultViewRacing();
    }
}
