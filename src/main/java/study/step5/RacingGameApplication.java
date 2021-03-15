package study.step5;

import study.step5.view.InputView;
import study.step5.view.ResultView;

public class RacingGameApplication {

    public static void main(String[] args) {
        InputView.inputCarNames();
        InputView.inputAttemptNumber();

        ResultView.printResultMessage();
    }
}
