package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;
import java.util.Scanner;

public class RacingMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int carCount = inputView.carCountView();
        int tryCount = inputView.tryCountView();

        ResultView resultView = new ResultView();
        resultView.view();

        RacingGame racingGame = new RacingGame();
        racingGame.generateCars(carCount);
        for (int i = 0; i < tryCount; i++) {
            List<Car> cars = racingGame.race();
            resultView.viewGame(cars);
        }
    }
}
