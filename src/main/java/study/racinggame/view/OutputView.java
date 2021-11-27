package study.racinggame.view;

import study.racinggame.domain.car.Car;
import study.racinggame.domain.car.Cars;

import java.util.List;

public class OutputView {
    public static void printSeparator() {
        System.out.println();
    }

    public static void printPosition(Cars cars) {
        cars.getCars().forEach(car -> {
            System.out.print(car.name() + ": ");

            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }

            System.out.println();
        });
    }

    public static void printWinners(List<Car> cars) {
        System.out.print("\n우승자: ");
        cars.forEach(car -> System.out.print(car.name() + " "));
    }
}
