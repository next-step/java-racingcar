package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarApplication {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        RandomStrategy randomStrategy = new RandomStrategy();
        RacingGame racingGame = new RacingGame();

        int carNumber = inputView.askNumberOfCars();
        int triesNumber = inputView.askNumberOfTries();

        racingGame.createCar(carNumber);

        for (int i = 0; i < triesNumber; i++) {
            List<Car> cars = racingGame.startGame(randomStrategy);
            outputView.printResult(cars);
        }
    }
}
