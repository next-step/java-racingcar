package game.view;

import game.domain.Car;
import game.domain.Cars;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public final class ResultView {

    public static final String POSITION_SYMBOL = "-";

    private ResultView() {
        throw new IllegalCallerException("잘못된 객체 생성입니다.");
    }

    public static void displayExecuteResultMessage() {
        displayNewLine();
        System.out.println("실행 결과");
    }

    public static void displayCarPositions(Cars cars) {
        for (Car car : cars.getCarList()) {
            displayName(car.name());
            displayPosition(car);
            displayNewLine();
        }
        displayNewLine();
    }

    private static void displayName(String name) {
        System.out.print(name + " : ");
    }

    private static void displayPosition(Car car) {
        IntStream.range(0, car.position())
                .forEach(n -> System.out.print(POSITION_SYMBOL));
    }

    private static void displayNewLine() {
        System.out.println();
    }

    public static void displayCarWinners(List<Car> winners) {
        String winnersAsString = winners.stream()
                .map(Car::name)
                .collect(joining(", "));
        System.out.println(String.format("%s가 최종 우승했습니다.", winnersAsString));
    }
}