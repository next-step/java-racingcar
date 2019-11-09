package retry.view;

import retry.domain.Car;
import retry.domain.Cars;

import java.util.List;

public class ResultView {

    public static void print(List<Cars> cars) {
        for (Cars racingCar : cars) {
            printRacingCars(racingCar);
            System.out.println("-----------------------");
        }
    }

    private static void printRacingCars(Cars racingCars) {
        for (Car car : racingCars.getCars()) {
            printCar(car);
        }
    }

    private static void printCar(Car car) {
        System.out.println(car.getName() + " : " + car.getPosition());
    }
}
