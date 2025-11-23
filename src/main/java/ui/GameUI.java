package ui;

import model.Car;

import java.util.List;

public class GameUI {
    public static void printCarsStatus(List<Car> cars) {
        for (Car car : cars) {
            printCarPosition(car.getPosition());
        }
        System.out.println();
    }

    private static void printCarPosition(int position) {
        System.out.println("-".repeat(position));
    }

}
