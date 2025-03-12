package car_racing;

import java.util.List;

public class CarPrinter {
    public static void showRaceStart() {
        System.out.println("\n실행 결과");
    }

    public static void showRaceResult(List<Car> cars) {
        cars.forEach(CarPrinter::showEachRaceResult);
        System.out.println();
    }

    private static void showEachRaceResult(Car car) {
        System.out.println("-".repeat(car.getDistance()));
    }
}
