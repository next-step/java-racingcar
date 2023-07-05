package racingcar;

import racingcar.controller.RacingGamePlayController;
import racingcar.controller.request.RacingGamePlayControllerRequest;
import racingcar.controller.response.RacingGamePlayControllerResponse;
import racingcar.input.ConsoleInput;
import racingcar.usecase.RacingGamePlayUsecase;
import racingcar.view.ConsoleView;

public class RacingApplication {

    public static void main(String[] args) {
        RacingGamePlayUsecase racingGamePlayUsecase = new RacingGamePlayUsecase();
        RacingGamePlayController racingGamePlayController = new RacingGamePlayController(racingGamePlayUsecase);

        ConsoleInput consoleInput = new ConsoleInput();
        RacingGamePlayControllerRequest input = consoleInput.input();
        RacingGamePlayControllerResponse response = racingGamePlayController.playRacingGame(input);
        ConsoleView consoleView = new ConsoleView();
        consoleView.printResult(response);
    }

}
