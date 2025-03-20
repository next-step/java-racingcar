package racinggame;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private OutputView() {

    }

    public static void printRace(Cars cars, int rounds) {
        System.out.println("실행 결과");
        for (int i = 0; i < rounds; i++) {
            cars.run(1);
            printCars(cars);
            System.out.println();
        }
    }

    public static void printWinners(List<Car> cars) {
        String winners = cars.stream()
            .map(Car::getName)
            .collect(Collectors.joining(", "));
        System.out.println(winners + "가 우승했습니다.");
    }

    private static void printCars(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + ":" + "-".repeat(car.getPosition()));
        }
    }
}
