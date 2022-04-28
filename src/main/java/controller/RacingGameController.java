package controller;

import dto.RacingHistoryDto;
import model.Cars;
import model.CarsFactory;
import model.MoveCount;
import service.RacingCarGame;
import view.InputView;
import view.ResultView;

public class RacingGameController {

    public static void main(String args[]) {
        String carsName = InputView.getInputCarsName();
        MoveCount moveCount = InputView.getInputCarMoveCount();

        ResultView.printResult();

        RacingCarGame racingCarGame = RacingCarGame.getInstance();
        Cars cars = CarsFactory.create(carsName);
        RacingHistoryDto racingHistoryDto = racingCarGame.race(cars, moveCount);

        ResultView.printResult(racingHistoryDto.getRoundHistories());
        ResultView.printWinnerCars(racingHistoryDto.getWinnerCarNames());
    }

}
