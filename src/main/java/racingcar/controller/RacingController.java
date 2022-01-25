package racingcar.controller;

import racingcar.model.domain.CarRegistration;
import racingcar.model.domain.Racing;
import racingcar.view.RacingCarUserConsole;
import racingcar.view.RacingCarUserResult;

public class RacingController {

    private static final int NUMBER_ZERO = 0;

    public static void racingController() {
        Racing racing = Racing.get();
        RacingCarUserConsole userConsole = new RacingCarUserConsole();
        RacingCarUserResult userResult = new RacingCarUserResult();
        userConsole.userInputRun();
        CarRegistration.instance(userConsole.getInputDTO().getSplitUserInput(), racing);
        for (int time = NUMBER_ZERO; time < userConsole.getInputDTO().getRacingTryCounter(); time++) {
            racing.drive();
            userResult.carsStatement(racing.getCars());
        }
        userResult.judge(racing.getCars());
        System.out.println(userResult.getOutputDTO().getResultMessage());
    }
}
