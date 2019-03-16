package racing;

public class Application {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(InputView.inputCarName());
        int tryCount = InputView.inputTryCount();

        while (tryCount-- > 0) {
            racingGame.playRacing();
            ResultView.printResult(racingGame.getRacingCar());
        }
        ResultView.printWinner(new WinnerCar().getWinners(racingGame.getRacingCar()));
    }
}