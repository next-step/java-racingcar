package racingcar.controller;

import racingcar.model.domain.Cars;
import racingcar.view.RacingCarUserConsole;
import racingcar.view.RacingCarUserResult;

public class RacingController {

    private static final int NUMBER_ZERO = 0;

    public static void racingController() {
        RacingCarUserConsole userConsole = new RacingCarUserConsole();
        RacingCarUserResult userResult = new RacingCarUserResult();
        userConsole.userInputRun();
        Cars cars = new Cars(
            userConsole.getInputDTO().getSplitUserInput());
        for (int time = NUMBER_ZERO; time < userConsole.getInputDTO().getRacingTryCounter(); time++) {
            cars.getRacing().drive();
            userResult.carsStatement(cars.getRacing().getCars());
        }
        userResult.judge(cars.getRacing().getCars());
        System.out.println(userResult.getOutputDTO().getResultMessage());
    }
}
