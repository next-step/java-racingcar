package racingcar.view;

import racingcar.domain.RacingCars;
import racingcar.domain.Winners;

public class OutputView {

    private static final String TITLE_RACING_RESULT = "실행 결과";
    private static final String GRAPH_FIGURE = "-";

    private OutputView() {

    }

    public static void printRacingResultTitle() {
        System.out.println(TITLE_RACING_RESULT);
    }

    public static void printRacing(RacingCars racingCars) {
        System.out.println(racingCars.showGraph(GRAPH_FIGURE));
        System.out.println();
    }

    public static void printWinners(Winners winners) {
        System.out.println(winners.showWinnerNames() + "가 최종 우승했습니다.");
    }
}
