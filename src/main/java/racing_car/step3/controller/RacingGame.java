package racing_car.step3.controller;

import racing_car.step3.domain.Cars;
import racing_car.step3.domain.CarsFactory;
import racing_car.step3.input.InputView;

public class RacingGame {
    private Cars cars;
    
    public RacingGame() {
        this.cars = new Cars(CarsFactory.from(InputView.inputNumberOfCars()));
    }
}