package racingcar;

public class RacingMain {
    public static void main(String[] args) {
        int carNames = InputView.getCarNo();
        int tryNo = InputView.getTryNo();
        RacingGame racingGame = new RacingGame(carNames, tryNo);
        RacingResult result = new RacingResult();
        result.executionResult(racingGame.getTryCnt(), racingGame.getRacingCars());
    }
}
