package study.step4;

public class RacingGame {

    public static void main(String[] args) {
        Racing racing = Racing.of(Cars.of(InputView.inputCarNames()), InputView.inputAttemptNumber(), new RandomMoveBehavior());
        ResultView.printResultMessage();

        System.out.println(!racing.isFinished());
    }
}
