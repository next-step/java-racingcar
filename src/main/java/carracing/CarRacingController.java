package carracing;

import carracing.view.InputView;
import carracing.view.OutputView;
import carracing.domain.CarRacingGame;
import carracing.domain.GameResult;
import carracing.domain.RandomNumberGenerator;

public class CarRacingController {
    public static void main(String[] args) {
        String carNumber = InputView.inputCarNumber();
        int gameCount = InputView.inputGameCount();

        CarRacingGame carRacingGame = new CarRacingGame(carNumber, gameCount, new RandomNumberGenerator());
        GameResult gameResult = carRacingGame.playGame();

        OutputView.printTotalResult(gameResult.getCarDistances());
        OutputView.printWinners(gameResult.getWinners());
    }
}
