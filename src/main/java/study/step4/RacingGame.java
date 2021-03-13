package study.step4;

public class RacingGame {

    public static void main(String[] args) {
        Racing racing = Racing.of(Cars.of(InputView.inputCarNames()), InputView.inputAttemptNumber(), new RandomMoveBehavior());
        ResultView.printResultMessage();

        while (!racing.isFinished()) {
            racing.race();
            ResultView.printRace(racing.getCars());
        }

        ResultView.printRaceWinner(racing.getWinners());
    }
}
