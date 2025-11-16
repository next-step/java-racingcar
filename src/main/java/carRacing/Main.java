package carRacing;

public class Main {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(InputView.initCarInfo());

        TryCount tryCount = new TryCount(InputView.initTryCount(), racingGame);
        tryCount.playGame();

        ResultView.printWinner(racingGame);
    }
}
