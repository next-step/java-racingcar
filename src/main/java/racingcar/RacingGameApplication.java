package racingcar;

import java.util.Random;

public class RacingGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int numberOfCars = inputView.getNumberOfCars();
        int tryCount = inputView.getTryCount();

        RacingGame game = new RacingGame(new Random(), numberOfCars);

        resultView.printGameResult();

        while (tryCount != 0) {
            game.progress();
            tryCount -= 1;

            resultView.printCarsPositions(game.getCars());
        }
    }
}
