package racing;

import racing.view.InputView;
import racing.view.ResultView;


public class RacingGameApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingGame racingGame = new RacingGame(inputView.inputCarCount(), inputView.inputTryCount());

        ResultView.init();
        racingGame.tryEvent();
    }
}
