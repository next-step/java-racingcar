package racing_car.step4.controller;

import racing_car.step4.domain.Cars;
import racing_car.step4.domain.RandomMoveStrategy;
import racing_car.step4.view.input.InputView;
import racing_car.step4.view.output.ResultView;

public class RacingGame {
    public void play() {
        Cars cars = moveAndGetCars(InputView.createCars(), InputView.inputNumberOfTry());
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