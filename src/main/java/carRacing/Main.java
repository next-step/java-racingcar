package carRacing;

public class Main {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(InputView.initCarInfo());

        int tryCount = InputView.initTryCount();
        for (int i = 0; i < tryCount; i++) {
            racingGame.playGame();
            ResultView.printResult(racingGame.getRacingCars());
        }
        ResultView.printWinner(racingGame);
    }
}
