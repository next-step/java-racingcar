package controller;

import domain.RacingCar;
import domain.RacingCarGame;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RacingCarController {

    public static void main(String[] args) {
        String[] createCarNames = InputView.inputCarNames();
        int tryCount = InputView.inputTryCount();

        RacingCarGame racingCarGame = new RacingCarGame(createCarNames);

        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            List<RacingCar> racingCars = racingCarGame.playAndReturnCars();
            OutputView.printCarsNameAndPositionStatus(racingCars);
        }

        List<RacingCar> cars = racingCarGame.getCars();
        OutputView.printWinners(RacingCarGame.getWinners(cars));
    }
}
