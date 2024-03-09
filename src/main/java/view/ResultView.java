package view;

import domain.Car;

import java.util.List;

public class ResultView {

    private ResultView() {
    }

    public static void print(List<Car> cars) {
        for (Car car : cars) {
            print(car);
            System.out.println();
        }
        System.out.println();
    }

    private static void print(Car car) {
        for (int i = 0; i < car.position().getPosition(); i++) {
            System.out.print("-");
        }
    }
}
