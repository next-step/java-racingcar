package study.step3;

public class RacingGame {

    public static void main(String[] args) {
        Racing racing = Racing.of(Cars.of(InputView.inputCarNumber()), InputView.inputAttemptNumber());
        ResultView.printResultMessage();

        while (!racing.isFinshed()) {
            // TODO 출력
        }
    }
}
