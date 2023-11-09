package racing.view;

import racing.domain.car.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void showCurrentPosition(List<List<Car>> result) {
        for (List<Car> cars : result) {
            printRound(cars);
            System.out.println();
        }
    }

    private static void printRound(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.name() + " : ");
            printCar(car);
            System.out.println();
        }
    }

    private static void printCar(Car car) {
        for (int i = 0; i < car.position().position(); ++i) {
            System.out.print("-");
        }
    }

    public static void showWinners(List<Car> cars) {
        List<String> names = cars.stream().map(c -> c.name().toString())
            .collect(Collectors.toList());
        System.out.println(names.toString() + "가 최종 우승했습니다.");
    }
}
