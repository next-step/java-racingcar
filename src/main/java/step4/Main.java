package step4;

import static step4.InputView.*;
import static step4.Separator.separateCarNames;

public class Main {
    public static void main(String[] args) {
        String[] carNames = separateCarNames(inputCarNames());
        int tryCount = inputTryCount();

        RacingHandler racingHandler = new RacingHandler(carNames);

        while (tryCount > 0) {
            ResultView.printProcess(racingHandler.getCarNameAndLocation());
            racingHandler.moveCar();
            tryCount--;
        }

        ResultView.printResult(racingHandler.getWinnerName());
    }
}
