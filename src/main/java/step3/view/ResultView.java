package step3.view;

import step3.Car;

import java.util.List;

public class ResultView {

    public static void displayCurrentCarsLocation(List<Car> cars) {
        for (Car car : cars) {
            displayCarLocation(car);
        }
        System.out.println();
    }

    private static void displayCarLocation(Car car) {
        for (int i = 0; i < car.getCurrentLocation(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
