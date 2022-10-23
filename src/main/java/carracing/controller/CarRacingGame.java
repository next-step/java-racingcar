package carracing.controller;


import carracing.domain.*;

import carracing.view.InputView;
import carracing.view.OutputView;

public class CarRacingGame {

    private final InputView inputView;
    private final OutputView outputView;

    public CarRacingGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Cars cars = Cars.makeCars(inputView.scanParticipantsName());
        startRacing(cars, inputView.scanTimes());
    }

    private void startRacing(Cars cars, int tryTimes) {

        Winners winners = new Winners(cars);

        outputView.printStart();

        for (int i = 0; i < tryTimes; i++){
            cars.moveCars(new RandomNumberMovingStrategy());
            printTrails(cars);
            outputView.printBlank();
        }

        outputView.printWinner(winners.findWinners());
    }

    private void printTrails(Cars cars) {
        for (Car car : cars.getCars()) {
            outputView.printTrail(car.getName(), car.getPositionTrail());
        }
    }
}
