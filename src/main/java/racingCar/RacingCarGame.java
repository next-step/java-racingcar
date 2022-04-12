package racingCar;

import racingCar.view.InputViewRacingCar;
import racingCar.view.ResultViewRacingCar;

public class RacingCarGame {

    private static InputViewRacingCar inputViewRacingCar;
    private static ResultViewRacingCar resultViewRacingCar;

    public RacingCarGame() {
        inputViewRacingCar = new InputViewRacingCar();
        resultViewRacingCar = new ResultViewRacingCar();
    }

    public void start() {
        inputViewRacingCar.inputRacingData();
        resultViewRacingCar.resultViewRacing();
    }
}
