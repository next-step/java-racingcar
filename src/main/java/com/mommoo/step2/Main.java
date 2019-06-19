package com.mommoo.step2;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int carCount = inputView.getCountOfCar();
        int times = inputView.getCountOfTrying();

        RacingGame racingGame = new RacingGame(carCount);

        ResultView resultView = new ResultView();

        while(times-- > 0) {
            int[] result = racingGame.move();
            for (int moveCount : result) {
                resultView.printCarMoveLine(moveCount);
            }
            System.out.println();
        }
    }
}
