package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomStrategy;
import racingcar.exception.CarNameException;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarApplication {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        RandomStrategy randomStrategy = new RandomStrategy();
        RacingGame racingGame = new RacingGame();

        try {
            String[] names = inputView.askNameOfCars();
            racingGame.createCar(names);
        } catch (CarNameException e) {
            e.printStackTrace();
            return;
        }

        int triesNumber = inputView.askNumberOfTries();

        for (int i = 0; i < triesNumber; i++) {
            List<Car> cars = racingGame.startGame(randomStrategy);
            outputView.printResult(cars);
        }

        List<String> winnerList = racingGame.calMaxWinner();
        outputView.printWinner(winnerList);
    }
}
