package game;

import domain.RacingGame;
import domain.RacingGameInfo;
import domain.RacingGameResult;
import domain.RandomNumberRule;
import ui.ConsoleUI;

public class ConsoleGame {
    private static ConsoleUI ui = new ConsoleUI();

    public static void start() {
        String carNames = ui.setCarNames();
        Integer gameCount = ui.setGameCount();

        RacingGame racingGame = new RacingGame(
            new RacingGameInfo(
                new RandomNumberRule(0, 10, 4),
                gameCount, carNames));
        RacingGameResult result = racingGame.play();

        ui.roundResults(result.getRoundResults());
        ui.winners(result.getRanking());
    }
}
