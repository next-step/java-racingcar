package racingCar.view;

import racingCar.domain.Car;

import java.util.List;

public class OutputView {

    public static void printCars(List<Car> racingCars) {
        for(Car car : racingCars) {
            System.out.println(car.toString());
        }
        System.out.println();
    }
}
