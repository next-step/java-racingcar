package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String MSG_RESULT = "실행 결과";
    private static final String GO_KEYWORD = "-";
    private static final String NAME_SEPARATE_KEYWORD = " : ";
    private static final String MSG_WINNER = "가 최종 우승했습니다.";

    public void printResultMessage() {
        System.out.println(MSG_RESULT);
    }

    public void printStatusFromScores(List<Car> cars) {
        cars.forEach(car -> {
            System.out.print(car.getName() + NAME_SEPARATE_KEYWORD);
            for (int i = 0; i < car.getScore().getNumber(); i++) {
                System.out.print(GO_KEYWORD);
            }
            System.out.println();
        });
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        System.out.println(winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(",")) + MSG_WINNER);
    }

}
