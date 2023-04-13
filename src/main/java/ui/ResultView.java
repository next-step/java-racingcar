package ui;

import car_racing.Car;

import java.util.List;

public class ResultView {
    public static void printMovingOfCars(List<Car> cars) {
        System.out.println("실행 결과");
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            System.out.println("-".repeat(car.getMoveCount()));
        }
    }
}
