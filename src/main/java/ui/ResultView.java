package ui;

import car_racing.Car;

import java.util.List;

public class ResultView {
    public static void printMovingOfCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println("-".repeat(car.getMoveCount()));
        }
    }
}
