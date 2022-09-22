package racing_car.step4.controller;

import racing_car.step4.domain.Cars;
import racing_car.step4.domain.RandomMoveStrategy;
import racing_car.step4.output.ResultView;

import static racing_car.step4.input.InputView.createCars;
import static racing_car.step4.input.InputView.inputNumberOfTry;

public class RacingGame {
    public void play() {
        Cars cars = moveAndGetCars(createCars(), inputNumberOfTry());
        ResultView.winnersPrint(cars);
    }
    
    private Cars moveAndGetCars(Cars cars, int numberOfTry) {
        ResultView.resultMessagePrint();
        return startMove(cars, numberOfTry);
    }
    
    private static Cars startMove(Cars cars, int numberOfTry) {
        while (numberOfTry-- > 0) {
            cars = new Cars(cars.tryMove(new RandomMoveStrategy()));
            ResultView.processPrint(cars);
        }
        return cars;
    }
}