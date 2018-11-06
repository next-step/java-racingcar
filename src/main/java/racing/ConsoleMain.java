package racing;

import racing.domain.GameResult;
import racing.domain.RacingGame;
import racing.view.InputView;
import racing.view.ResultView;

public class ConsoleMain {

    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int tryNo = InputView.getTryNumber();

        RacingGame racingGame = new RacingGame(carNames);
        GameResult result = null;

        for (int i = 0; i < tryNo; i++) {
            result = racingGame.startGame();
            ResultView.showResult(result);
        }
        ResultView.showWinner(result);
    }

}
