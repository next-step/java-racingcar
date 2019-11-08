package step3;

import step3.domain.Car;
import step3.domain.RacingGame;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.*;

public class RacingGameController {

    public void execute() {
        RacingGame racingGame = initiate();
        printResult(racingGame.getCars(), racingGame.getTime());
        printWinner(racingGame.getCars(), racingGame.calculateWinnerPosition());
    }

    private RacingGame initiate() {
        InputView inputView = new InputView();
        String carObject = inputView.createCar();
        int moveCount = inputView.moveCount();
        return new RacingGame(moveCount, carObject);
    }

    private void printResult(List<Car> cars, int time) {
        ResultView.printCar(cars, time);
    }

    private void printWinner(List<Car> cars, int winnerPosition) {
        ResultView.printWinner(cars, winnerPosition);
    }
}