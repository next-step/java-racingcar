package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    private static final String RACING_RESULT = "실행 결과";
    private static final String GRAPH_FIGURE = "-";

    private OutputView() {

    }

    public static void printRacingResultTitle(){
        System.out.println(RACING_RESULT);
    }

    public static void showRacingResult(List<Car> cars) {
        cars.forEach(car -> {
            System.out.println(drawGraph(car));
        });
        System.out.println();
    }

    private static String drawGraph(Car car) {
        StringBuilder graph = new StringBuilder();
        for (int i = 0; i < car.getDistance(); i++) {
            graph.append(GRAPH_FIGURE);
        }
        return graph.toString();
    }
}
