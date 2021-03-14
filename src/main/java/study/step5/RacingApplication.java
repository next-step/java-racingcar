package study.step5;

import study.step5.ui.InputView;

public class RacingApplication {
    public static void main(String[] args) {
        RacingService racingService = new RacingService();
        racingService.ready(InputView.inputCarNames());
        racingService.play(InputView.inputRound());
    }
}
