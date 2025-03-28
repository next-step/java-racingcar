package ui;

import study.Car;

import java.util.List;

public class ResultView {
    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getPosition());
        }
        System.out.println();
    }

    public static void printCarString(StringBuilder position ) {
        position.append("-");
    }
}

