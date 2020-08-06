package racingcar;

import racingcar.domain.MotorRacing;
import racingcar.ui.MotorRacingUserInput;
import racingcar.ui.UserInputInfo;
import racingcar.ui.view.MotorRacingDisplayResults;

import static racingcar.ui.MotorRacingDisplay.racingResultDisplay;

public class RacingCarGameApplication {
    public static void main(String[] args) {
        UserInputInfo userInputInfo = MotorRacingUserInput.input();
        MotorRacingDisplayResults motorRacingDisplayResults = motorRacingGameStart(userInputInfo);
        racingResultDisplay(motorRacingDisplayResults);
    }

    private static MotorRacingDisplayResults motorRacingGameStart(UserInputInfo userInputInfo) {
        final MotorRacing motorRacing = MotorRacing.randomMotorRacing(userInputInfo.getCarNames());
        return motorRacing.racing(userInputInfo.getTryCount());
    }
}
