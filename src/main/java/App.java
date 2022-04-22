import racing.domain.RacingGame;
import racing.view.InputView;
import racing.view.ResultView;

public class App {
    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int tryCount = InputView.getTryCount();
        RacingGame racingGame = new RacingGame(carNames, tryCount);

        ResultView.printRacingResultMessage();
        while (racingGame.isRacing()) {
            racingGame.race();
            ResultView.printCarsPosition(racingGame.getCarsStatus());
        }
        ResultView.printWinnerCars(racingGame.getWinnerCars());
    }
}
