package woowacamp.racingcar.view;

import woowacamp.racingcar.domain.Car;
import woowacamp.racingcar.domain.Name;

import java.util.List;
import java.util.stream.Collectors;

public class ConsoleOutput {
    private static final String POSITON_SYMBOL = "-";

    public static void printResultHeader() {
        System.out.println("실행 결과");
    }

    public static void printCurrentStatus(List<CarStatus> cars) {
        for (CarStatus car : cars) {
            String position = POSITON_SYMBOL.repeat(car.getPosition());
            System.out.println(car.getName() + " : " + position);
        }
        System.out.println();
    }

    public static void printWinners(List<CarStatus> winners) {
        String winnerNames = winners.stream()
                .map(CarStatus::getName)
                .collect(Collectors.joining(", "));

        System.out.print(winnerNames + "가 최종 우승했습니다.");
    }
}
