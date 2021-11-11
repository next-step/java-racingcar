package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    public static void print() {
        System.out.println();
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static String print(Car car) {
        StringBuilder result = new StringBuilder();
        if (car.getName() != null) {
            result.append(car.getName()).append(" : ");
        }
        for (int i = 0; i < car.getState(); i++) {
            result.append("-");
        }
        return result.toString();
    }

    public static String print(List<Car> cars) {
        StringBuilder result = new StringBuilder();
        for (Car car : cars) {
            result.append(OutputView.print(car)).append("\n");
        }
        return result.toString();
    }
}
