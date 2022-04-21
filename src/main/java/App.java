public class App {
    public static void main(String[] args) {
        String carNames = InputView.inputRacingCarNames();
        int attemptsCount = InputView.inputAttemptsCount();
        RacingGame racingGame = new RacingGame(carNames, attemptsCount);
        RacingRecords result = racingGame.StartRacing();
        ResultView.print(result);
    }
}
