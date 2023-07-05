package woowacamp.racingcar.view;

import woowacamp.racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ConsoleOutput {
    private static final String POSITON_SYMBOL = "-";

    public static void printResultHeader() {
        System.out.println("실행 결과");
    }

    public static void printCurrentStatus(List<Car> cars) {
        for (Car car : cars) {
            String position = POSITON_SYMBOL.repeat(car.getPositionValue());
            System.out.println(car.getNameValue() + " : " + position);
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getNameValue)
                .collect(Collectors.joining(", "));

        System.out.print(winnerNames + "가 최종 우승했습니다.");
    }
}
