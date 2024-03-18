package race.controller;

import race.domain.Car;
import race.domain.CarFactory;
import race.domain.RacingGame;
import race.domain.Winner;
import race.view.InputView;
import race.view.ResultView;

import java.util.List;

public class RacingMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        RacingGame racingGame = new RacingGame();
        List<Car> carList = CarFactory.createCars(inputView.inputCar());
        int tryCount = inputView.inputTry();

        resultView.printResult();

        for (int i = 0; i < tryCount; i++) {
            racingGame.race(carList);
            resultView.showResult(carList);
        }

        resultView.showWinners(new Winner().findWinner(carList));
    }
}
