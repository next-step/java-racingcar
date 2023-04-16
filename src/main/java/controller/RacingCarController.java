package controller;

import domain.RacingCarGame;
import domain.RacingCarList;
import domain.strategy.RandomMoveStrategy;
import view.InputView;
import view.OutputView;

public class RacingCarController {

    public static void main(String[] args) {
        String[] createCarNames = InputView.inputCarNames();
        int tryCount = InputView.inputTryCount();

        RacingCarGame racingCarGame = new RacingCarGame(new RacingCarList(createCarNames, new RandomMoveStrategy()));

        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            RacingCarList cars = racingCarGame.playAndReturnCars();
            OutputView.printCarsNameAndPositionStatus(cars.getCars());
        }

        OutputView.printWinners(racingCarGame.getWinners());
    }
}
