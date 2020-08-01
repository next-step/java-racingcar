package racingcar;

import racingcar.domain.MotorRacing;
import racingcar.ui.Counter;
import racingcar.ui.MotorRacingUserInput;
import racingcar.ui.dto.MotorRacingDisplayResults;

import static racingcar.ui.MotorRacingDisplay.racingResultDisplay;

public class RacingCarGameApplication {
    public static void main(String[] args) {
        final Counter counter = MotorRacingUserInput.inputCount();
        final MotorRacingDisplayResults results = motorRacingGameStart(counter);
        racingResultDisplay(results);
    }

    private static MotorRacingDisplayResults motorRacingGameStart(Counter counter) {
        final MotorRacing motorRacing = MotorRacing.randomMotorRacing(counter.getCarCount());
        return motorRacing.racing(counter.getTryCount());
    }
}
