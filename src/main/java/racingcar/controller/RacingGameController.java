package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.CarService;
import racingcar.view.InputView;

import java.util.List;

public enum RacingGameController {

    INSTANCE;

    private final CarService carService = CarService.INSTANCE;
    private List<Car> cars;

    public void run() {
        createCars();
    }

    private void createCars() {
        int numberOfCars = InputView.INSTANCE.InputNumberOfCars();

        for (int i = 0; i < numberOfCars; i++) {
            carService.addCar(new Car());
        }

        cars = carService.findCars();
    }
}
