package racingcar.app;

import racingcar.consoleinput.ConsoleInput;
import racingcar.consoleview.ConsoleView;
import racingcar.controller.RacingGamePlayController;
import racingcar.controller.extension.input.Inputable;
import racingcar.controller.extension.view.Viewable;
import racingcar.randommove.RandomMover;

public class RacingApplication {

    private final RacingGamePlayController racingGamePlayController;

    public static void main(String[] args) {
        RacingApplication racingApplication = new RacingApplication();
        racingApplication.run();
    }

    private RacingApplication() {
        Inputable consoleInput = ConsoleInput.getInstance();
        Viewable consoleView = ConsoleView.getInstance();
        this.racingGamePlayController =
            new RacingGamePlayController(consoleInput, consoleView, RandomMover.newInstance());
    }

    private void run() {
        racingGamePlayController.playRacingGame();
    }

}
