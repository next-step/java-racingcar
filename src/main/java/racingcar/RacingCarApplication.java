package racingcar;

import racingcar.controller.RacingGame;
import racingcar.controller.RacingScreen;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.console.ConsoleInputView;
import racingcar.view.console.ConsoleOutputView;

public class RacingCarApplication {

    public static void main(String[] args) {
        final InputView inputView = new ConsoleInputView();
        final OutputView outputView = new ConsoleOutputView();
        final RacingScreen racingScreen = new RacingScreen(inputView, outputView);

        new RacingGame(racingScreen).play();
    }
}
