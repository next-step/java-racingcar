package racingGame;

public class Play {
    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int tryNo = InputView.getTryNo();

        RacingGame racingGame = new RacingGame(carNames, tryNo);
        while (racingGame.isEnd()) {
            racingGame.race();
            ResultView.printResult(racingGame.getCars());
        }
        ResultView.printWinners(racingGame.findWinners());
    }
}
