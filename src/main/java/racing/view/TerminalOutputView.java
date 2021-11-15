package racing.view;

import racing.model.Car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TerminalOutputView {

    private static final String CAR_MOVING_BAR = "-";
    private static final String STATUS_SEPARATOR = " : ";
    private static final String NAME_SEPARATOR = ", ";

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

    public static void printWinnersCars(List<Car> cars) {
        List<String> names = cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        String namesFullString = String.join(NAME_SEPARATOR, names);
        System.out.println(namesFullString + "가 최종 우승했습니다.");
    }

    public static void printEmptyLine() {
        System.out.println();
    }
}
