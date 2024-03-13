package racingCar;


import static view.InputView.inputNamesOfCars;
import static view.InputView.inputNumberOfTry;
import static view.ResultView.printAward;
import static view.ResultView.printResult;

public class RacingGame {

    public void run() {
        RacingCars cars = new RacingCars(CarFactory.createCars(inputNamesOfCars()));
        doRacing(cars, inputNumberOfTry());
        printAward(RacingReferee.pickWinners(cars));;
    }

    private void doRacing(RacingCars cars, int numberOfTries) {
        for (int i = 0; i < numberOfTries; i++) {
            cars.moveCars();
            printResult(cars);
        }
    }

}
