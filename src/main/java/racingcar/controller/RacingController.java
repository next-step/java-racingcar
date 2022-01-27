package racingcar.controller;

import racingcar.model.domain.Cars;
import racingcar.model.domain.Racing;
import racingcar.model.domain.RandomNumberBehavior;
import racingcar.view.RacingCarUserConsole;
import racingcar.view.RacingCarUserResult;

public class RacingController {

    private static final int NUMBER_ZERO = 0;

    public void run() {
        RacingCarUserConsole userConsole = new RacingCarUserConsole();
        RacingCarUserResult userResult = new RacingCarUserResult();
        userConsole.userInputRun();

        Cars cars = new Cars(
            userConsole.getInputDTO().getSplitUserInput());
        Racing racing = new Racing(cars.getCars(), RandomNumberBehavior.getInstance());
        for (int time = NUMBER_ZERO; time < userConsole.getInputDTO().getRacingTryCounter();
            time++) {
            racing.drive();
            userResult.carsStatement(racing.getCars());
        }
        userResult.judge(racing.getCars());
        System.out.println(userResult.getOutputDTO().getResultMessage());
    }
}
