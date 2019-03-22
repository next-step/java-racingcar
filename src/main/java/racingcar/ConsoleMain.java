package racingcar;

import racingcar.domain.*;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class ConsoleMain {
    public static void main(String[] args) {

        String[] carNames = InputView.getCarNames();
        int tryNo = InputView.getTryNo();

        RacingGame racingGame = new RacingGame(new CarMovableRandomDecider(), new RacingGameState(carNames, tryNo));
        RacingResult result = null;

        while(!racingGame.isEnd()) {
            result = racingGame.race();
            ResultView.printResult(result);
        }
        ResultView.printWinners(result);
    }
}