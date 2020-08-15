package racingcar.view;

import racingcar.constant.Constant;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    public static void printResult(Cars cars) {
        cars.stream().forEach(car ->
                System.out.println(car.getName() + Constant.COLON
                        + printHyphen(car.getPosition())));
        System.out.println();
    }

    public static String printHyphen(int position) {
        return IntStream.rangeClosed(1, position)
                .mapToObj(s -> Constant.HYPHEN)
                .collect(Collectors.joining(""));
    }

    public static void printWinner(List<Car> winner) {
        String winnerNames = winner.stream()
                .map(Car::getName)
                .collect(Collectors.joining(Constant.COMMA));
        System.out.println(winnerNames + Constant.WINNER_NOTICE);
    }
}