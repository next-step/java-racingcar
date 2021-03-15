package study.step5;

import study.step5.domain.Cars;
import study.step5.domain.Racing;
import study.step5.domain.RandomMoveBehavior;
import study.step5.view.InputView;
import study.step5.view.ResultView;

public class RacingGameApplication {

    public static void main(String[] args) {
        Racing racing = Racing.of(Cars.of(InputView.inputCarNames()), InputView.inputAttemptNumber(), new RandomMoveBehavior());
        ResultView.printResultMessage();

        while (!racing.isFinished()) {
        }
    }
}
