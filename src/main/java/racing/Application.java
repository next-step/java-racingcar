package racing;

public class Application {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(InputView.inputCarName());
        int tryCount = InputView.inputTryCount();
        int racing = tryCount;
        while (racing-- > 0) {
            racingGame.playRacing();
            ResultView.printResult(racingGame.getRacingCars());
        }
        ResultView.printWinner(racingGame.getWinner(tryCount));
    }
}