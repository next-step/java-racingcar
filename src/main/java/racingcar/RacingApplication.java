package racingcar;

import racingcar.controller.RacingGamePlayController;
import racingcar.controller.request.RacingGamePlayControllerRequest;
import racingcar.controller.response.RacingGamePlayControllerResponse;
import racingcar.usecase.RacingGamePlayUsecase;
import racingcar.view.input.ConsoleInput;
import racingcar.view.output.ConsoleOutput;

public class RacingApplication {

    private final ConsoleInput consoleInput;
    private final ConsoleOutput consoleOutput;
    private final RacingGamePlayController racingGamePlayController;

    public static void main(String[] args) {
        RacingApplication racingApplication = new RacingApplication();
        racingApplication.run();
    }

    private RacingApplication() {
        this.consoleInput = new ConsoleInput();
        this.consoleOutput = new ConsoleOutput();
        this.racingGamePlayController = new RacingGamePlayController(new RacingGamePlayUsecase());
    }

    private void run() {
        RacingGamePlayControllerRequest input = consoleInput.input();
        RacingGamePlayControllerResponse response = racingGamePlayController.playRacingGame(input);
        consoleOutput.printResult(response);
    }

}
