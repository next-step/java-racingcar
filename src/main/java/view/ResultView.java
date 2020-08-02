package view;

import domain.Car;

import java.util.List;

public class ResultView {
    public static void print(List<Car> cars) {

        for (Car car : cars) {
            System.out.println(car.printLocation());
        }

        System.out.println();
    }
}
