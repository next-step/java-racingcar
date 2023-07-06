package woowacamp.racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

public class ConsoleOutput {
    private static final String POSITION_SYMBOL = "-";

    public static void printResultHeader() {
        System.out.println("실행 결과");
    }

    public static void printCurrentStatus(List<CarStatus> cars) {
        for (CarStatus car : cars) {
            String position = POSITION_SYMBOL.repeat(car.getPosition());
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
