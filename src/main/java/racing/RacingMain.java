package racing;

public class RacingMain {
    public static void main(String[] args) {
        int carCount = RacingInputView.inputCarCount();
        int gameCount = RacingInputView.inputGameCount();

        RacingResultView.makeRacingResult(gameCount, RacingGame.makeCarList(carCount));
    }
}
