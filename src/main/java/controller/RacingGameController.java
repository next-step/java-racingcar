package controller;

import model.Car;
import model.Cars;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGameController {

    public static void main(String args[]) {
        InputView inputView = new InputView();
        int carsNumber = inputView.getInputCarsNumber();
        int carMoveCount = inputView.getInputCarMoveCount();

        Cars cars = makeCars(carsNumber);
        moveCars(carMoveCount, cars);
    }

    private static Cars makeCars(int carsNumber) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carsNumber; i++) {
            cars.add(new Car());
        }
        return new Cars(cars);
    }

    private static void moveCars(int carMoveCount, Cars cars) {
        ResultView resultView = new ResultView();
        for (int i = 0; i < carMoveCount; i++) {
            resultView.printMoveCarResult(cars);
        }
    }

}
