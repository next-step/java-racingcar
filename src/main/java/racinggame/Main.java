package racinggame;

import racinggame.game.RacingGame;
import racinggame.ui.InputView;
import racinggame.ui.ResultView;

public class Main {

    public static void main(String[] args) {
        final var carName = InputView.promptCarName();
        final var roundCount = InputView.promptRounds();

        final var game = RacingGame.of(carName, roundCount);
        final var result = game.start();

        ResultView.promptGameResult(result);
        ResultView.promptWinners(game.findWinners());
    }
}
