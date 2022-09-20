package racing_car.step3.controller;

import racing_car.step3.domain.Cars;
import racing_car.step3.domain.CarsFactory;
import racing_car.step3.input.InputView;
import racing_car.step3.output.ResultView;

public class RacingGame {
    private final Cars cars;
    
    public RacingGame() {
        int numberOfCars = InputView.inputNumberOfCars();
        this.cars = new Cars(CarsFactory.from(numberOfCars));
    }
    
    public void play() {
        int numberOfTry = InputView.inputNumberOfTry();
        while (numberOfTry-- > 0) {
            cars.move();
            ResultView.processPrint(cars);
        }
    }
}