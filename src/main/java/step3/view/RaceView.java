package step3.view;

import step3.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class RaceView {

    public static void displayDescription() {
        System.out.println("실행 결과");
    }

    public static void displayRaceSituation(List<Car> cars) {
        for (Car car : cars) {
            printCarPosition(car);
        }
        System.out.println("");
    }

    public static void displayWinners(List<Car> winners) {
        System.out.println(joinCarNames(winners) + "가 최종 우승했습니다.");
    }

    private static void printCarPosition(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }

    private static String joinCarNames(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
