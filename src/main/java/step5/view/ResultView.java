package step5.view;

import step5.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final char dash = '-';

    public static void printLocations(List<Car> cars) {
        for (Car car : cars) {
            printCarLocation(car);
        }
    }

    public static void printCarLocation(Car car) {
        System.out.printf("%s : ", car.getName());
        for (int i = 0; i < car.getLocation(); i++)
            System.out.print(dash);
        System.out.println();
    }

    public static void printWinner(List<Car> winners) {
        String names = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.printf("%s(이)가 최종 우승했습니다.", names);
    }
}
