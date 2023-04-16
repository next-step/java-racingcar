package step3;

public class RacingController {
    public static void main(String[] args) {
        final int carCount = InputView.numberOfCar();
        final int matchCount = InputView.numberOfAttempts();

        final Racing racing = new Racing(carCount,matchCount);

        ResultView.printScore(racing.race());
    }
}
