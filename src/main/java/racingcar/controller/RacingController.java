package racingcar.controller;

import racingcar.model.domain.CarRegistration;
import racingcar.model.domain.Racing;
import racingcar.view.RacingCarUserInput;
import racingcar.view.RacingCarUserOutput;

public class RacingController {
    private static final int NUMBER_ZERO = 0;

    public static void racingController() {
        Racing racing = Racing.get();
        RacingCarUserInput userInput = new RacingCarUserInput();
        RacingCarUserOutput judgement = new RacingCarUserOutput();
        userInput.userInputRun();
        CarRegistration.instance(userInput.getInputDTO().getSplitUserInput(), racing);
        for (int time = NUMBER_ZERO; time < userInput.getInputDTO().getRacingTryCounter(); time++) {
            racing.drive();
            judgement.carsStatement(racing.getCars());
        }
        judgement.judge(racing.getCars());
    }
}
