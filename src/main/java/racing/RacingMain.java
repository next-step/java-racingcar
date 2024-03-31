package racing;

import racing.domain.RacingGame;

import static racing.view.InputView.inputCarNames;
import static racing.view.InputView.inputTryCount;
import static racing.domain.RacingGame.getCars;
import static racing.view.ResultView.printResultMessage;

public class RacingMain {
    public static void main(String[] args) {
        String[] names = inputCarNames().split(",");
        RacingGame game = new RacingGame(inputTryCount(), getCars(names));

        printResultMessage();

        game.race();
    }
}
