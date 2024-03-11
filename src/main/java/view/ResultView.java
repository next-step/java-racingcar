package view;

import domain.Car;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    private ResultView() {
    }

    public static void print(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }

    public static void printWinner(List<Car> winners) {
        List<String> names = getNames(winners);
        System.out.printf("%s가 최종 우승했습니다.%n", String.join(", ", names));
    }

    private static List<String> getNames(List<Car> cars) {
        List<String> names = new ArrayList<>();
        for (Car car : cars) {
            names.add(car.getName());
        }
        return names;
    }
}
