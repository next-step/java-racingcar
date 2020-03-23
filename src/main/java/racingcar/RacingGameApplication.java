package racingcar;

import java.util.Random;

public class RacingGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        inputView.input();

        RacingGame game = new RacingGame(new Random(), inputView.getInputData());

        resultView.printGameResult();

        while (!game.isFinish()) {
            game.progress();

            resultView.printCarsPositions(game.getCars());
        }
    }
}
