package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Winners;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {

    private static final String TITLE_RACING_RESULT = "실행 결과";
    private static final String GRAPH_FIGURE = "-";
    private static final String FORMAT_PRINT_RACING = "%s : %s \n";

    private OutputView() {

    }

    public static void printRacingResultTitle() {
        System.out.println(TITLE_RACING_RESULT);
    }

    public static void printRacing(List<Car> cars) {
        cars.forEach(car -> System.out.printf(FORMAT_PRINT_RACING, car.showName(), printGraph(car)));
        System.out.println();
    }

    private static String printGraph(Car car) {
        StringBuilder graph = new StringBuilder();
        IntStream.range(0, car.showDistance()).forEach(a -> graph.append(GRAPH_FIGURE));
        return graph.toString();
    }

    public static void printWinners(Winners winners) {
        String winnerNames = winners.showWinners().stream()
                .map(Car::showName)
                .collect(Collectors.joining(","));

        System.out.println(winnerNames+ "가 최종 우승했습니다.");
    }
}
