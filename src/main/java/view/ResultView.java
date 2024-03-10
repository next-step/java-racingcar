package view;

import domain.Car;

import java.util.List;

public class ResultView {

    private ResultView() {
    }

    public static void print(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }
}
