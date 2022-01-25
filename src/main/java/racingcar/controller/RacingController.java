package racingcar.controller;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import racingcar.model.domain.CarRegistration;
import racingcar.model.domain.Racing;
import racingcar.view.RacingCarUserInput;
import racingcar.view.RacingCarUserOutput;

public class RacingController {
    private static final int NUMBER_ZERO = 0;
    public static void racingController() {
        Racing racing = Racing.get();
        RacingCarUserInput userInput = new RacingCarUserInput();
        RacingCarUserOutput userOutput = new RacingCarUserOutput();
        userInput.userInputRun();
        CarRegistration.instance(userInput.getInputDTO().getSplitUserInput(), racing);
        for (int time = NUMBER_ZERO; time < userInput.getInputDTO().getRacingTryCounter(); time++) {
            racing.drive();
            userOutput.carsStatement(racing.getCars());
        }
        userOutput.judge(racing.getCars());
        System.out.println(userOutput.getOutputDTO().getResultMessage());
    }
}
