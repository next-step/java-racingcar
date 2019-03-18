import domain.RacingGame;
import domain.RacingGameInfo;
import domain.RacingGameResult;
import domain.RandomNumberRule;
import util.StringParser;
import view.ConsoleView;

public class ConsoleMain {
    private static ConsoleView ui = new ConsoleView();

    public static void start() {
        String carNames = ui.setCarNames();
        Integer gameCount = ui.setGameCount();

        RacingGame racingGame = new RacingGame(
            new RacingGameInfo(
                new RandomNumberRule(0, 10, 4),
                gameCount, StringParser.split(carNames)));
        RacingGameResult result = racingGame.play();

        ui.roundResults(result.getRoundResults());
        ui.winners(result.getWinner());
    }
}
