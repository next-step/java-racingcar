package racing_car.step4.controller;

import racing_car.step4.domain.Cars;
import racing_car.step4.domain.CarsFactory;
import racing_car.step4.domain.RandomMoveStrategy;
import racing_car.step4.input.InputView;
import racing_car.step4.output.ResultView;

public class RacingGame {
    public void play() {
        Cars cars = createCars();
        startMove(cars, InputView.inputNumberOfTry());
    }
    
    private void startMove(Cars cars, int numberOfTry) {
        ResultView.resultMessagePrint();
        
        while (numberOfTry-- > 0) {
            cars = new Cars(cars.tryMove(new RandomMoveStrategy()));
            ResultView.processPrint(cars);
        }
    }
    
    private Cars createCars() {
        int numberOfCars = InputView.inputNumberOfCars();
        return new Cars(CarsFactory.from(numberOfCars));
    }
}