package step3;

import step3.domain.Car;
import step3.domain.RacingGame;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.*;

public class RacingGameController {

    public void execute() {
        RacingGame racingGame = initiate();
        moveResultView(racingGame);
        printWinnerView(racingGame);
    }

    private RacingGame initiate() {
        InputView inputView = new InputView();
        String carObject = inputView.createCar();
        int moveCount = inputView.moveCount();
        return new RacingGame(moveCount, carObject);
    }

    private void moveResultView(RacingGame racingGame) {
        int time = racingGame.getTime();
        for (int i = 0; i < time; i++) {
            List<Car> cars = racingGame.move();
            ResultView.printCar(cars);
        }
    }

    private void printWinnerView(RacingGame racingGame) {
        List<Car> cars = racingGame.getWinners();
        for (Car car : cars) {
            getWinner(car);
        }
        ResultView.printWinner();
    }

    private void getWinner(Car car) {
        if (car.isWinner()) {
            ResultView.getWinners(car.getName());
        }
    }
}