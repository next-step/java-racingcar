package racingcargamefinal.domain;

import racingcargamefinal.ui.InputView;
import racingcargamefinal.ui.ResultView;

public class RacingMain {

    public static void main(String[] args) {
        String carsName = InputView.readCarsName();
        int tryCount = InputView.readTryCount();

        RacingGame racingGame = new RacingGame(carsName, tryCount);

        ResultView.printResultMessage();
        while (!racingGame.isEnd()) {
            racingGame.play();
            ResultView.printResult(racingGame.getCars());
        }
        ResultView.printWinners(racingGame.findWinners());
    }

}
