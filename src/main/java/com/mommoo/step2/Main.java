package com.mommoo.step2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String[] carNames = inputView.getCarNames();
        int times = inputView.getCountOfTrying();

        RacingGame racingGame = new RacingGame(carNames);

        ResultView resultView = new ResultView();

        while(times-- > 0) {
            List<Car> carList = racingGame.move();
            for (Car car : carList) {
                resultView.printCarMoveLine(car);
            }
            System.out.println();
        }

        List<Car> finalCarList = racingGame.currentCarList();
        resultView.printFinalWinner(finalCarList);
    }
}
