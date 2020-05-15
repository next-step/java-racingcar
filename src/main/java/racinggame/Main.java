package racinggame;

public class Main {
    public static void main(String[] args) {
        int carCount = InputView.enterCarCount();
        int round = InputView.enterRound();

        RacingGame racingGame = new RacingGame(carCount, round, new RandomMovableStrategy());
        racingGame.start();

        ResultView resultView = new ResultView(racingGame.getResultCarPositions());
        resultView.show();
    }
}
