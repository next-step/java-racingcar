package racingGame;

import racingGame.controller.RacingGame;
import racingGame.ui.input.ConsoleInputView;
import racingGame.ui.input.InputView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();

        RacingGame game = new RacingGame(inputView.getCarCount(), inputView.getMoveCount());

        game.play();
    }
}
