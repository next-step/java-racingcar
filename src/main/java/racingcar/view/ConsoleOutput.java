package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ConsoleOutput {
    private static final String POSITON_SYMBOL = "-";

    public static void printResultHeader() {
        System.out.println("실행 결과");
    }

    public static void printCurrentStatus(final List<Car> cars) {
        for (final Car car : cars) {
            String position = POSITON_SYMBOL.repeat(car.getPosition().getValue());
            System.out.println(car.getName().getValue() + " : " + position);
        }
        System.out.println();
    }

    public static void printWinners(final List<Car> winners) {
        final String winnerNames = winners.stream()
                .map(car -> car.getName().getValue())
                .collect(Collectors.joining(", "));

        System.out.print(winnerNames + "가 최종 우승했습니다.");
    }
}
