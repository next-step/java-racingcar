package racingcar;

import racingcar.domain.RacingGame;
import racingcar.domain.RandomStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarApplication {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RandomStrategy randomStrategy = new RandomStrategy();
        RacingGame rg = new RacingGame();

        int carNumber = inputView.askNumberOfCars();
        int triesNumber = inputView.askNumberOfTries();

        rg.createCar(carNumber);

        for (int i = 0; i < triesNumber; i++) {
            rg.startGame(carNumber, randomStrategy, outputView);
        }
    }
}
