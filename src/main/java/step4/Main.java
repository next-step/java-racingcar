package step4;

import static step4.InputView.*;
import static step4.Util.separateCarNames;

public class Main {
    public static void main(String[] args) {
        String[] carNames = separateCarNames(inputCarNames());
        int tryCount = inputTryCount();

        ResultView resultView = new ResultView();
        Winner winner = new Winner(carNames);

        while (tryCount > 0) {
            winner.findLocationAndWinnerName();
            tryCount--;
        }

        resultView.printResult(winner.findLocationAndWinnerName());
    }
}
