package study.step5;

import study.step5.view.InputView;

public class RacingApplication {
    public static void main(String[] args) {
        Racing racing = new Racing();
        racing.ready(InputView.inputCarNames());
        racing.play(InputView.inputRound());
    }
}
