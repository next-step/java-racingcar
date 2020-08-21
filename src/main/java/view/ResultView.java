package view;

import core.Car;
import core.Cars;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    private static final String RESULT_GUIDE = "가 최종 우승했습니다.";

    private ResultView() {};

    public static void printRoundResult(List<Car> cars) {
        cars.stream().forEach(car -> System.out.println(getStringFromPosition(car)));
        System.out.println();
    }

    public static void printWinnersName(Cars cars) {
        List<String> winnersName = getWinnersName(cars);
        System.out.println(winnersName.stream().collect(Collectors.joining(","))+RESULT_GUIDE);
    }

    public static String getStringFromPosition(Car car) {
        return IntStream.range(0, car.position)
                        .mapToObj(i -> "-")
                        .collect(Collectors.joining(""));
    }

    public static List<String> getWinnersName(Cars cars) {
        return Cars.getWinnersName(cars);
    }
}
