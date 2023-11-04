package step3.controller;

import step3.domain.Car;
import step3.domain.CarFactory;
import step3.validite.RandomNumber;
import step3.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RaceController {

    private static final RandomNumber RANDOM_NUMBER = new RandomNumber();

    public void startRace(int carNumber, int moveNumber) {
        CarFactory carFactory = new CarFactory();
        OutputView outputView = new OutputView();
        carFactory.participants(carNumber);
        List<Car> cars = carFactory.carsInfo();

        for (int i = 0; i < moveNumber; i++) {
            moveCars(cars);
            outputView.print(cars.stream().map(Car::toString).collect(Collectors.toList()));
        }
    }

    public void moveCars(List<Car> cars) {
        for (Car car : cars) {
            car.move(RANDOM_NUMBER.randomNumberCreate());
        }
    }
}
