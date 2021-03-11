package step4;

public class Main {
    //private static RacingGame racingGame = new RacingGame(new InputView(), new RacingGame(), new ResultView());

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(new InputView());
        racingGame.start();
    }
}
