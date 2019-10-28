package project.game;

public class Main {
    public static void main(String[] args) {
        RacingGameView racingGameView = new RacingGameConsoleView();
        RacingGame racingGame = new RacingGame(racingGameView);

        racingGame.start(GameType.RANDOM);
    }
}
