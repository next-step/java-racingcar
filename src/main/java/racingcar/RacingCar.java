package racingcar;

import racingcar.ui.ResultView;

public class RacingCar {
    public static void play(int carCount, int moveCount) {
        Cars cars =  new Cars(carCount);
        for(int i=0; i<moveCount; i++){
            cars.moveCars();
            ResultView.printMovingCars(cars);
        }
    }
}
