package study.step5;

import study.step5.domain.Cars;
import study.step5.domain.Racing;
import study.step5.domain.RandomMoveBehavior;
import study.step5.view.InputView;
import study.step5.view.ResultView;

public class RacingGameApplication {

    public static void main(String[] args) {
        String[] carNames = InputView.inputCarNames();
        int attemptNumber = InputView.inputAttemptNumber();
        Racing racing = Racing.of(
                Cars.of(carNames),
                attemptNumber,
                new RandomMoveBehavior()
        );

        ResultView.printResultMessage();
        while (!racing.isFinished()) {
            racing.race();
            ResultView.printRace(racing.getCars());
        }

        ResultView.printRaceWinner(racing.getWinners());
    }
}
