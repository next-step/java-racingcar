package racingcar.ui;

import racingcar.Car;
import racingcar.Cars;

public class ResultView {

    public static void printMovingCars(Cars cars){
        for (Car car : cars.getCars()) {
            printMovingCar(car);
        }
        System.out.println();
    }

    private static void printMovingCar(Car car) {
        for(int i=0; i<car.getPosition(); i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
