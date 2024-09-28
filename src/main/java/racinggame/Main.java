package racinggame;

import racinggame.game.RacingGame;
import racinggame.ui.InputView;
import racinggame.ui.ResultView;

public class Main {

    public static void main(String[] args) {
        final var carCount = InputView.promptCarCount();
        final var roundCount = InputView.promptRounds();

        final var game = new RacingGame(carCount, roundCount);
        final var result = game.start();

        ResultView.promptGameResult(result);
    }
}
