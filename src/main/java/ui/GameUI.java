package ui;

import model.Car;

import java.util.List;

public class GameUI {
    public static void printCarsStatus(List<Car> cars) {
        for (Car car : cars) {
            printCarPosition(car.getName(), car.getPosition());
        }
        System.out.println();
    }

    private static void printCarPosition(String carName, int position) {
        System.out.printf("%s : %s%n", carName, "-".repeat(position));
    }
}
