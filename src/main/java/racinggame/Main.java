package racinggame;

import racinggame.game.RacingGame;
import racinggame.ui.InputView;
import racinggame.ui.ResultView;
import racinggame.utils.RandomUtils;

public class Main {

    private static final int BOUND = 10;
    private static final int MOVABLE_MINIMUM_NUMBER = 4;

    public static void main(String[] args) {
        final var carCount = InputView.promptCarCount();
        final var rounds = InputView.promptRounds();

        final var game = new RacingGame(carCount, () -> RandomUtils.getRandomNumber(BOUND) >= MOVABLE_MINIMUM_NUMBER);
        game.start(rounds);

        ResultView.promptResult(game.getCars());
    }
}
