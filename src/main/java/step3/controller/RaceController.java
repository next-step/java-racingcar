package step3.controller;

import step3.domain.Car;
import step3.domain.CarFactory;
import step3.validite.ValidityCheck;
import step3.view.OutputView;

import java.util.List;

public class RaceController {

    public void startRace(int carNumber, int moveNumber) {
        CarFactory carFactory = new CarFactory();
        OutputView outputView = new OutputView();
        carFactory.participants(carNumber);
        List<Car> cars = carFactory.carsInfo();

        for (int i = 0; i < moveNumber; i++) {
            carFactory.moveCars();
            outputView.printCars(cars);
        }
    }
}
