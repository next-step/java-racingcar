package com.mommoo.step2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] carNames = InputView.getCarNames();
        int times = InputView.getCountOfTrying();

        RacingGame racingGame = new RacingGame(carNames);

        while(times-- > 0) {
            List<Car> carList = racingGame.move();
            for (Car car : carList) {
                ResultView.printCarMoveLine(car);
            }
            System.out.println();
        }

        List<Car> finalCarList = racingGame.currentCarList();
        CarWinnerComputer carWinnerComputer = new CarWinnerComputer(finalCarList);

        ResultView.printFinalWinner(carWinnerComputer);
    }
}
