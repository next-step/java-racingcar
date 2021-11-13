package racing.view;

import racing.model.Car;

import java.util.Collections;
import java.util.List;

public class TerminalOutputView {

    private static final String CAR_MOVING_BAR = "-";

    private TerminalOutputView() {}

    public static void printCars(List<Car> cars) {
        cars.stream()
                .map(car -> Collections.nCopies(car.getMovingDistance(), CAR_MOVING_BAR))
                .map(bars -> String.join("", bars))
                .forEach(System.out::println);
        System.out.println();
    }

    public static void printStartSentence() {
        System.out.println("실행 결과");
    }
}
