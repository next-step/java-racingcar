package racingGame;

public class Play {
    public static void main(String[] args) {

        InputView inputView = new InputView();

        int carCount = inputView.readCarCount();
        int tryCount = inputView.readTryCount();

        RacingGame game = new RacingGame(carCount, tryCount, new RandomMoveStrategy());

        java.util.List<Round> rounds = game.race();

        ResultView resultView = new ResultView();
        resultView.print(rounds);
    }
}
