package racingcar;

import racingcar.controller.RacingGamePlayController;
import racingcar.controller.request.RacingGamePlayControllerRequest;
import racingcar.controller.response.RacingGamePlayControllerResponse;
import racingcar.input.ConsoleInput;
import racingcar.usecase.RacingGamePlayUsecase;
import racingcar.view.ConsoleView;

public class RacingApplication {

    private final ConsoleInput consoleInput;
    private final ConsoleView consoleView;
    private final RacingGamePlayController racingGamePlayController;

    public static void main(String[] args) {
        RacingApplication racingApplication = new RacingApplication();
        racingApplication.run();
    }

    private RacingApplication() {
        this.consoleInput = new ConsoleInput();
        this.consoleView = new ConsoleView();
        this.racingGamePlayController = new RacingGamePlayController(new RacingGamePlayUsecase());
    }

    private void run() {
        RacingGamePlayControllerRequest input = consoleInput.input();
        RacingGamePlayControllerResponse response = racingGamePlayController.playRacingGame(input);
        consoleView.printResult(response);
    }

}
