package racingcar;

import racingcar.service.RacingCar;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Main {

    public static void main(String[] args) {
        ResultView.printNameOfCars();
        String cars = InputView.inputNameOfCars();

        ResultView.printNumberOfMovements();
        int movements = InputView.inputNumberOfMovements();

        RacingCar racingCar = new RacingCar(cars);

        ResultView.printRacingResult();
        for (int i = 0; i < movements; i++) {
            racingCar.start();
            ResultView.printStatusOfCars(racingCar.getStatusOfCars());
        }
    }
}
