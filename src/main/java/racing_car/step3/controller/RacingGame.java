package racing_car.step3.controller;

import racing_car.step3.domain.Cars;
import racing_car.step3.domain.CarsFactory;
import racing_car.step3.input.InputView;
import racing_car.step3.output.ResultView;

public class RacingGame {
    public void play() {
        Cars cars = getCars();
        startMove(cars, InputView.inputNumberOfTry());
    }
    
    private static void startMove(Cars cars, int numberOfTry) {
        ResultView.resultMessagePrint();
        
        while (numberOfTry-- > 0) {
            cars.move();
            ResultView.processPrint(cars);
        }
    }
    
    private static Cars getCars() {
        int numberOfCars = InputView.inputNumberOfCars();
        return new Cars(CarsFactory.from(numberOfCars));
    }
}