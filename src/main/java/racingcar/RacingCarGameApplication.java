package racingcar;

import racingcar.ui.Counter;
import racingcar.ui.MotorRacingUserInput;

import static racingcar.ui.MotorRacingDisplay.racingResultDisplay;

public class RacingCarGameApplication {
    public static void main(String[] args) {
        Counter counter = MotorRacingUserInput.inputCount();
        racingResultDisplay(counter);
    }
}
