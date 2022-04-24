package racingcar;

import racingcar.domain.RacingGame;
import racingcar.domain.RandomStrategy;
import racingcar.exception.CarNameException;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarApplication {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        RandomStrategy randomStrategy = new RandomStrategy();
        RacingGame racingGame = new RacingGame();
        try {
            racingGame.createCar(inputView.askNameOfCars());
        } catch (CarNameException e) {
            e.printStackTrace();
            return;
        }

        int tries = inputView.askNumberOfTries();
        for (int i = 0; i < tries; i++) {
            outputView.printResult(racingGame.startGame(randomStrategy));
        }
        outputView.printWinner(racingGame.findWinner());
    }
}
