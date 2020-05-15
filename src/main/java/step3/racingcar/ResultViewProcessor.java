package step3.racingcar;

import java.util.List;
import java.util.function.Function;

public class ResultViewProcessor {
    private ResultViewProcessor() {
    }

    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            printCurrentPosition(car);
        }
        System.out.println();
    }

    public static void printResultHeader(String headerMessage) {
        System.out.println(headerMessage);
    }

    private static void printCurrentPosition(Car car) {
        int currentPosition = car.getPosition();
        for (int i = 0; i < currentPosition; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
