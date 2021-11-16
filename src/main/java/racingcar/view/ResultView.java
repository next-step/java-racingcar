package racingcar.view;

import racingcar.Car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String CAR_RACING_FIGURE = "-";
    private static final String DELIMITER = ",";

    private ResultView() {
    }

    public static void printStartResultView() {
        System.out.println("실행 결과");
    }

    public static void printResultView(List<Car> racingCar) {

        racingCar.stream()
                .map(car -> car.getName() + " : " + String.join("", Collections.nCopies(car.getLocation(), CAR_RACING_FIGURE)))
                .forEach(System.out::println);

        System.out.println("\n");

    }

    public static void printWinnerView(List<Car> winner) {
        String winnerString = winner.stream()
                .map(Car::getName)
                .collect(Collectors.joining(DELIMITER));

        System.out.println(winnerString + "가 최종 우승했습니다.");
    }
}
