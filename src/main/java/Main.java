import racingcar.*;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        GameInputs userArgs = inputView.createUserArgument();
        RacingGame racingGame = RacingGame.createGame(userArgs);

        GameResults results = racingGame.start();

        resultView.printGameResult(results);
    }
}
