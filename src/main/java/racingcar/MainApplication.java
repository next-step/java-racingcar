package racingcar;

public class MainApplication {
    public static void main(String[] args) {

        String[] carNames = InputView.getCarNames();
        int tryNo = InputView.getTryNo();

        RacingGame racingGame = new RacingGame(carNames, tryNo);
        RacingResult result = null;

        while(!racingGame.isEnd()) {
            result = racingGame.race();
            ResultView.printResult(result);
        }
        ResultView.printWinners(result);
    }
}
