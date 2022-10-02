package racing;

import racing.view.InputView;

public class RacingGameApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingGame racingGame = new RacingGame(inputView.inputCarCount(), inputView.inputTryCount());
        racingGame.tryEvent();
    }
}