package racingcar.app;

import racingcar.app.input.ConsoleInput;
import racingcar.app.view.ConsoleView;
import racingcar.controller.RacingGamePlayController;
import racingcar.controller.request.RacingGamePlayControllerRequest;
import racingcar.domain.response.RacingGamePlayResponse;

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
        this.racingGamePlayController = new RacingGamePlayController();
    }

    private void run() {
        RacingGamePlayControllerRequest input = consoleInput.input();
        RacingGamePlayResponse response = racingGamePlayController.playRacingGame(input);
        consoleView.printResult(response);
    }

}
