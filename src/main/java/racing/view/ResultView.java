package racing.view;

import racing.domain.Cars;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultView {
    private static final String POSITION = "-";
    private static final String CONNECT_CHAR = " : ";

    private ResultView() {
    }

    public static void printCarNameAndPosition(Cars cars) {
        cars.getCarList().forEach(car -> System.out.println(car.getName() + CONNECT_CHAR + repeat(car.getPosition())));
    }

    private static String repeat(int count) {
        return Stream.generate(() -> POSITION)
                .limit(count)
                .collect(Collectors.joining());
    }

    public static void printVictoryCarNames(String victoryCarNames) {
        System.out.println(victoryCarNames + "가 최종우승 했습니다.");
    }
}
