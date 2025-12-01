import controller.RacingGame;
import view.InputView;
import view.ResultView;

public class RacingGameApplication {
    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int tryNumber = InputView.getTryNumber();

        RacingGame racingGame = new RacingGame(carNames, tryNumber);

        ResultView.printRaceStartMessage();
        while (!racingGame.isEnd()) {
            ResultView.printStatus(racingGame.race());
        }
        ResultView.printWinners(racingGame.winners());
    }
}
