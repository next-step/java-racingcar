package carracing;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int carNumber = InputView.inputCarNumber();
        int gameCount = InputView.inputGameCount();

        Random random = new Random();
        CarRacingGame carRacingGame = new CarRacingGame(carNumber, random.nextLong());
        List<List<Integer>> gameResult = carRacingGame.playGame(gameCount);

        OutputView.printTotalResult(gameResult);
    }
}
