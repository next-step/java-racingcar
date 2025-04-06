package view;

import domain.Car;
import domain.Cars;
import domain.CarsSnapShots;

import java.util.stream.Collectors;

public final class ResultView {

    public static void printWinners(Cars cars) {
        System.out.println(getNames(cars) + "가 최종 우승했습니다.");
    }

    private ResultView() {}

    public static void printResult(final CarsSnapShots carsSnapShots) {
        carsSnapShots.getCars().forEach(cars -> {
            cars.getCars().forEach(car -> {
                printCarPosition(car.getName(), car.getPosition());
                System.out.println();
            });
            System.out.println();
        });
    }

    public static void printTitle() {
        System.out.println("실행 결과");
    }

    private static void printCarPosition(String name, int position) {
        System.out.print(name + ": " + "-".repeat(position));
    }

    private static String getNames(Cars cars) {
        return cars.getCars().stream().map(Car::getName).collect(Collectors.joining(","));
    }
}
