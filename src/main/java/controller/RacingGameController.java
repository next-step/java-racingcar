package controller;

import model.Car;
import model.Cars;
import model.PositiveCarMoveCount;
import model.PositiveCarsNumber;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGameController {

    public static void main(String args[]) {
        InputView inputView = new InputView();
        PositiveCarsNumber positiveCarsNumber = inputView.getInputCarsNumber();
        PositiveCarMoveCount positiveCarMoveCount = inputView.getInputCarMoveCount();

        Cars cars = makeCars(positiveCarsNumber.getCarsNumber());
        moveCars(positiveCarMoveCount.getCarMoveCount(), cars);
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
