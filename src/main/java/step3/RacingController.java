package step3;

public class RacingController {
    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final int carCount = inputView.numberOfCar();
        final int matchCount = inputView.numberOfAttempts();

        final Racing racing = new Racing(carCount,matchCount);
        racing.raceStart();

        final ResultView resultView = new ResultView();
        resultView.printScore(racing.scoreBoard());
    }
}
