package carracing;

import carracing.ui.InputView;
import carracing.ui.OutputView;
import carracing.controller.CarRacingGame;
import carracing.domain.GameResult;
import carracing.domain.RandomNumberGenerator;

public class Main {
    public static void main(String[] args) {
        String carNumber = InputView.inputCarNumber();
        int gameCount = InputView.inputGameCount();

        CarRacingGame carRacingGame = new CarRacingGame(carNumber, gameCount, new RandomNumberGenerator());
        GameResult gameResult = carRacingGame.playGame();

        OutputView.printTotalResult(gameResult.getCarDistances());
        OutputView.printWinners(gameResult.getWinners());
    }
}
