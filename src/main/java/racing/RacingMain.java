package racing;

import static racing.InputView.inputCarNames;
import static racing.InputView.inputTryCount;
import static racing.RacingGame.getCars;
import static racing.ResultView.printResultMessage;

public class RacingMain {
    public static void main(String[] args) {
        String[] names = inputCarNames().split(",");

        printResultMessage();

        RacingGame game = new RacingGame(inputTryCount(), getCars(names));

        game.race();
    }
}
