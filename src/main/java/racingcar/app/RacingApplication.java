package racingcar.app;

import java.util.List;
import racingcar.app.input.ConsoleInput;
import racingcar.app.view.ConsoleView;
import racingcar.controller.RacingGamePlayController;
import racingcar.domain.response.RacingGamePlayResponse;
import racingcar.randommove.RandomMover;

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
        this.racingGamePlayController = new RacingGamePlayController(consoleInput, consoleView, RandomMover.newInstance());
    }

    private void run() {
        List<String> carNames = consoleInput.inputCarNames();
        int round = consoleInput.inputRound();
        racingGamePlayController.playRacingGame();
    }

}
