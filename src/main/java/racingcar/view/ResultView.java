package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    private static final String WINNER_NOTICE = "가 최종 우승했습니다!";

    public static void printResult(Cars cars) {
        cars.stream().forEach(car ->
                System.out.println(car.getName() + " : "
                        + printHyphen(car.getPosition())));
        System.out.println();
    }

    public static String printHyphen(int position) {
        return IntStream.rangeClosed(1, position)
                .mapToObj(s -> "-")
                .collect(Collectors.joining(""));
    }

    public static void printWinner(List<Car> winner) {
        String winnerNames = winner.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winnerNames + WINNER_NOTICE);
    }
}