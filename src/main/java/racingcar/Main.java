package racingcar;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int carCount = inputView.readCarCount();
        int tryCount = inputView.readTryCount();

        RacingGame racingGame = new RacingGame(carCount, tryCount);

        List<List<Integer>> history = racingGame.race(new RandomNumberGenerator());

        ResultView resultView = new ResultView();

        resultView.printHeader();
        for (List<Integer> positions : history) {
            resultView.printTurn(positions);
        }
    }
}
