package project.game;

public class Main {
    public static void main(String[] args) {
        RacingGameView racingGameView = new RacingGameViewImpl();
        RacingGame racingGame = new RacingGame(racingGameView);

        racingGame.start(GameType.RANDOM);
    }
}
