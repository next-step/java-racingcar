package racinggame.mvc;

import racinggame.mvc.domain.RacingGame;
import racinggame.mvc.domain.RacingResult;
import racinggame.mvc.view.InputView;
import racinggame.mvc.view.ResultView;

public class RacingGameApplication {
    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int tryCount = InputView.getTryNo();

        RacingGame racingGame = new RacingGame(carNames, tryCount);
        ResultView.printHeader();
        RacingResult result;
        do {
            result = racingGame.race();
            ResultView.printResult(result);
        } while (!racingGame.isEnd());
        ResultView.printWinners(result);
    }
}
