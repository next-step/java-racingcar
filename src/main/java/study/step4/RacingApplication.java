package study.step4;

import study.step4.ui.InputView;

public class RacingApplication {
    public static void main(String[] args) {
        RacingService racingService = new RacingService();
        racingService.ready(InputView.inputCarNames());
        racingService.play(InputView.inputRound());
    }
}
