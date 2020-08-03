package racingcar;

import racingcar.domain.MotorRacing;
import racingcar.ui.MotorRacingUserInputWithCarNames;
import racingcar.ui.UserInputInfoWithCarNames;
import racingcar.ui.UserInputInfoWithCount;
import racingcar.ui.MotorRacingUserInputWithCounter;
import racingcar.ui.dto.MotorRacingDisplayResults;

import static racingcar.ui.MotorRacingDisplay.racingResultDisplay;

public class RacingCarGameApplication {
    public static void main(String[] args) {
        UserInputInfoWithCarNames userInputInfo = MotorRacingUserInputWithCarNames.input();
        MotorRacingDisplayResults motorRacingDisplayResults = motorRacingGameStart(userInputInfo);
        racingResultDisplay(motorRacingDisplayResults);
    }

    private static MotorRacingDisplayResults motorRacingGameStart(UserInputInfoWithCarNames userInputInfoWithCarNames) {
        final MotorRacing motorRacing = MotorRacing.randomMotorRacing(userInputInfoWithCarNames.getCarNames());
        return motorRacing.racing(userInputInfoWithCarNames.getTryCount());
    }
}
