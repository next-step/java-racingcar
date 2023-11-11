package racingcar;

public class RacingGame {
    public static void main(String[] args) {
        String racerNames = InputView.racerNames();
        int roundCount = InputView.roundCount();
        Racing racing = new Racing(racerNames, roundCount);

        if (!racing.holdPossible()) {
            ResultView.noRace();
            return;
        }

        ResultView.racingStart();
        for (int round = 0; round < roundCount; round++) {
            racing.processRound();
            ResultView.carStatPrint(racing.racingInfo());
            ResultView.roundFinish();
        }

        ResultView.winner(racing.racingInfo());
    }
}
