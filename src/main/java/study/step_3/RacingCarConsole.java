package study.step_3;

import study.step_3.view.InputView;

public class RacingCarConsole {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Input input = inputView.generateInput();

        RacingGame racingGame = new RacingGame(input);
        racingGame.start();
    }
}
