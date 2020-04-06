package racingcar.ui;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String POSITION_DISPLAY_CHARACTER = "-";

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            printPosition(car);
        }
    }

    private static void printPosition(Car car) {
        StringBuilder builder = new StringBuilder(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            builder.append(POSITION_DISPLAY_CHARACTER);
        }
        System.out.println(builder.toString());
    }

    public static void printWinner(List<Car> winners) {
        String collect = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println(collect + "가 최종 우승했습니다.");
    }
}
