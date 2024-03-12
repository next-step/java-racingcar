package game.view;

import game.domain.Car;

import java.util.List;

public class ResultView {

    public static void printPlainMessage(final String message) {
        System.out.println(message);
    }

    public static void printCars(final List<Car> cars) {
        cars.forEach(car -> {
            String distance = "-".repeat(Math.max(0, car.getDistance()));
            ResultView.printPlainMessage(car.getName() + " : " + distance);
        });
    }
}
