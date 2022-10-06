package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Winners;

import java.util.List;
import java.util.stream.Collectors;

public class ConsoleOutput {

    private static final String STATUS_FORMAT = "%s : %s%n";

    private ConsoleOutput() {
    }

    public static void resultMessage() {
        System.out.println("레이싱 게임 결과입니다.");
    }

    public static void printStatus(List<Car> cars) {
        cars.forEach(
                car -> System.out.printf(STATUS_FORMAT, car.knowName(), "-".repeat(Math.max(0, car.knowPosition())))
        );
        System.out.println();
    }

    public static void printWinner(Winners winners) {
        System.out.print(
                winners.getElements()
                        .stream()
                        .map(Car::knowName)
                        .collect(Collectors.joining(", "))
        );
        System.out.println("가 최종 우승했습니다.");
    }
}
