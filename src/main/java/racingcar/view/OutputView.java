package racingcar.view;

import racingcar.domain.Car;

public class OutputView {

    public static void print() {
        System.out.println();
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void print(Car car) {
        StringBuilder result = new StringBuilder();
        if (car.getName() != null) {
            result.append(car.getName()).append(" : ");
        }
        for (int i = 0; i < car.getState(); i++) {
            result.append("-");
        }
        print(result.toString());
    }
}
