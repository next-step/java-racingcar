package racingcar.app;

import java.util.List;
import racingcar.app.input.ConsoleInput;
import racingcar.app.view.ConsoleView;
import racingcar.controller.RacingGamePlayController;
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
        this.consoleInput = ConsoleInput.getInstance();
        this.consoleView = ConsoleView.getInstance();
        this.racingGamePlayController = RacingGamePlayController.getInstance();
    }

    private void run() {
        List<String> carNames = consoleInput.inputCarNames();
        int round = consoleInput.inputRound();
        RacingGamePlayResponse response = racingGamePlayController.playRacingGame(round, carNames);
        consoleView.printResult(response);
    }

}
