package racingcar;

public class RacingGame {
    public static void main(String[] args) {
        Racing racing = new Racing(InputView.carCount(), InputView.roundCount());

        if (!racing.holdPossible()) {
            ResultView.noRace();
            return;
        }

        ResultView.racingStart();
        racing.race();
    }
}
