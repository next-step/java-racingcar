package car_racing.view;

import car_racing.domain.model.Car;
import car_racing.domain.model.Cars;

public class CarPrinter {
    public static void showRaceStart() {
        System.out.println("\n실행 결과");
    }

    public static void showRaceResult(Cars cars) {
        cars.forEach(CarPrinter::showEachRaceResult);
        System.out.println();
    }

    private static void showEachRaceResult(Car car) {
        System.out.println("-".repeat(car.getDistance()));
    }
}
