package game;

import domain.RacingGame;
import domain.RacingGameInfo;
import domain.RacingGameResult;
import domain.RandomNumberRule;
import ui.ConsoleUI;

import java.util.Scanner;

public class ConsoleGame implements Game{
    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        ConsoleUI ui = new ConsoleUI();

        ui.setCarNames();
        String carNames = scanner.nextLine();

        ui.setGameCount();
        Integer gameCount = scanner.nextInt();

        RacingGame racingGame = new RacingGame(
            new RacingGameInfo(
                new RandomNumberRule(0, 10, 4),
                gameCount, carNames));
        RacingGameResult result = racingGame.play();

        ui.roundResults(result.getRoundResults());
        ui.winners(result.getRanking());
    }
}
