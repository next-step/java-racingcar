package step3.controller;

import step3.domain.CarRacing;

public class CarRacingController {

    public static void main(String[] args) {
        String carNameString = InputView.inputCarCount();
        int tryCount = InputView.inputTryCount();

        CarRacing carRacing = new CarRacing(carNameString, tryCount);

        ResultView.printResultStart();

        ResultView.printResult(carRacing.racingGameStart());

        ResultView.printWinner(carRacing.extractWinner());
    }
}
