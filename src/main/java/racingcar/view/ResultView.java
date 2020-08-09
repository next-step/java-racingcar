package racingcar.view;

import racingcar.domain.Cars;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    public static void printResult(Cars cars) {
        cars.stream().forEach(car -> System.out.println(printHyphen(car.getPosition())));
        System.out.println();
    }

    public static String printHyphen(int position) {
        return IntStream.rangeClosed(1, position)
                .mapToObj(s -> "-")
                .collect(Collectors.joining(""));
    }
}
