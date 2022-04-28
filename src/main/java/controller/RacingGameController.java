package controller;

import model.Cars;
import model.CarsFactory;
import model.MoveCount;
import model.RoundHistory;
import service.RacingCarGame;
import view.InputView;
import view.ResultView;

import java.util.List;

public class RacingGameController {

    public static void main(String args[]) {
        String carsName = InputView.getInputCarsName();
        MoveCount moveCount = InputView.getInputCarMoveCount();

        RacingCarGame racingCarGame = new RacingCarGame(carsName, moveCount);

        ResultView.printResult();

        Cars cars = CarsFactory.create(carsName);
        List<RoundHistory> moveHistories = racingCarGame.race(cars, moveCount);

        ResultView.printResult(moveHistories);
        ResultView.printWinnerCars(cars.getWinnerCars());
    }

}
