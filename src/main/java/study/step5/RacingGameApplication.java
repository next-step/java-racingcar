package study.step5;

import study.step5.domain.Cars;
import study.step5.domain.Racing;
import study.step5.view.ResultView;

public class RacingGameApplication {

    public static void main(String[] args) {
        Racing racing = Racing.of(Cars.of(study.step4.InputView.inputCarNames()), study.step4.InputView.inputAttemptNumber());
        ResultView.printResultMessage();
    }
}
