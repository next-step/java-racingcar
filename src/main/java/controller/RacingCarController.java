package controller;

import domain.RacingCar;
import view.InputView;
import view.ResultView;

public class RacingCarController {

    public void start() {
        InputView inputView = InputView.create();
        String carNames = inputView.getCarNames();
        int tryCount = inputView.getTryCount();

        ResultView.start();
        RacingCar racingCar = new RacingCar(carNames,tryCount);

        for (int i = 0; i < tryCount; i++) {
            ResultView.showRace(racingCar.race());
        }
        ResultView.showWinners(racingCar.winner());
    }
}