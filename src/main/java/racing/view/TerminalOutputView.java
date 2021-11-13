package racing.view;

import racing.model.Car;

import java.util.Collections;
import java.util.List;

public class TerminalOutputView {

    private static final String CAR_MOVING_BAR = "-";
    private static final String STATUS_SEPARATOR = " : ";

    private TerminalOutputView() {}

    public static void printCars(List<Car> cars) {
        cars.stream()
                .map(TerminalOutputView::mapCarStatusBarFrom)
                .forEach(System.out::println);
        System.out.println();
    }

    private static String mapCarStatusBarFrom(Car car) {
        StringBuilder carStatusBarBuilder = new StringBuilder();
        carStatusBarBuilder.append(car.getName());
        carStatusBarBuilder.append(STATUS_SEPARATOR);

        List<String> bars = Collections.nCopies(car.getMovingDistance(), CAR_MOVING_BAR);
        String barStatus = String.join("", bars);
        carStatusBarBuilder.append(barStatus);

        return carStatusBarBuilder.toString();
    }

    public static void printStartSentence() {
        System.out.println("실행 결과");
    }
}
