package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Winners;

import java.util.List;

public class OutputView {

    private static final String TITLE_RACING_RESULT = "실행 결과";
    private static final String GRAPH_FIGURE = "-";

    private OutputView() {

    }

    public static void printRacingResultTitle() {
        System.out.println(TITLE_RACING_RESULT);
    }

    public static void printRacing(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.showGraph(GRAPH_FIGURE)));
        System.out.println();
    }

    public static void printWinners(Winners winners) {
        System.out.println(winners.showWinnerNames() + "가 최종 우승했습니다.");
    }
}
