package study;

import java.util.List;

public class OutputView {
    public static void printSeparator() {
        System.out.println();
    }

    public static void printPosition(Car car) {
        System.out.print(car.getName() + ": ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinners(List<Car> cars) {
        System.out.print("\n우승자: ");
        cars.forEach(car -> System.out.print(car.getName() + " "));
    }
}
