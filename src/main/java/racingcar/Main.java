package racingcar;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<String> carNames = inputView.readCarNames();
        int tryCount = inputView.readTryCount();

        RacingGame racingGame = new RacingGame(carNames, tryCount);

        List<TurnResult> history = racingGame.race(new RandomNumberGenerator());

        ResultView resultView = new ResultView();

        resultView.printHeader();
        for (TurnResult turnResult : history) {
            resultView.printTurn(turnResult);
        }
        resultView.printWinners(racingGame.winners());
    }
}
