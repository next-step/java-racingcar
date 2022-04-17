package service;

import model.Car;
import model.Cars;
import model.Position;
import model.PositiveNumber;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private RacingCarGame() {

    }

    public static RacingCarGame getInstance() {
        return new RacingCarGame();
    }

    public void play(PositiveNumber carNumber, PositiveNumber carMoveCount) {
        Cars cars = makeCars(carNumber);
        moveCars(carMoveCount, cars);
    }

    private Cars makeCars(PositiveNumber carsNumber) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carsNumber.getNumber(); i++) {
            cars.add(new Car(new Position()));
        }
        return new Cars(cars);
    }

    private void moveCars(PositiveNumber carMoveCount, Cars cars) {
        ResultView resultView = ResultView.getInstance();
        resultView.printResult();

        for (int i = 0; i < carMoveCount.getNumber(); i++) {
            cars.moveCars();
            cars.printCarsPosition();
        }
    }
}
