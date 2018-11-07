package racinggame;

import racinggame.domain.RacingGame;
import racinggame.domain.RacingResult;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class RacingMain {
    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int tryNo = InputView.getTryNo();

        RacingGame racingGame = new RacingGame(carNames);
        RacingResult result = racingGame.racing(tryNo);

        ResultView.printResult(result);
    }
}
