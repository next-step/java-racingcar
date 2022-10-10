package carracing.controller;

import carracing.domain.Car;
import carracing.domain.Cars;
import carracing.domain.RandomGenerator;
import carracing.domain.WinnerChecker;
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

        RandomGenerator randomGenerator = new RandomGenerator();
        WinnerChecker winnerChecker = new WinnerChecker();

        outputView.printStart();

        for (int i = 0; i < tryTimes; i++){
            cars.moveCars(randomGenerator);
            printTrails(cars);
            outputView.printBlank();
        }

        outputView.printWinner(winnerChecker.findWinners(cars));
    }

    private void printTrails(Cars cars) {
        for (Car car : cars.getCars()) {
            outputView.printTrail(car.getName(), car.getPosition());
        }
    }
}
