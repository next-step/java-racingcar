package racingCar.view;

import racingCar.model.Cars;

public class ResultView {
    private ResultView(){}
    public static void printCars(Cars cars){
        cars.move();
    }
}
