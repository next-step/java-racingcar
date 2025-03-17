package carracing;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int carNumber = InputView.inputCarNumber();
        int gameCount = InputView.inputGameCount();
        
        CarRacingGame carRacingGame = new CarRacingGame(carNumber, new RandomNumberGenerator());
        List<List<String>> gameResult = carRacingGame.playGame(gameCount);

        OutputView.printTotalResult(gameResult);
    }
}
