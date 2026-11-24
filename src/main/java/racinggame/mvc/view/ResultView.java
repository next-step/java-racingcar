package racinggame.mvc.view;

import java.util.StringJoiner;
import racinggame.mvc.domain.Car;
import racinggame.mvc.domain.RacingResult;

public class ResultView {

    private static final String RESULT_HEADER = "실행 결과";
    private static final String POSITION_SEPARATOR = " : ";
    private static final String POSITION_MARK = "-";
    private static final String WINNER_SEPARATOR = ", ";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    private ResultView() {
    }

    public static void printHeader() {
        System.out.println();
        System.out.println(RESULT_HEADER);
    }

    public static void printResult(RacingResult result) {
        for (Car car : result.getCars()) {
            System.out.println(car.getName() + POSITION_SEPARATOR + POSITION_MARK.repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(RacingResult result) {
        StringJoiner names = new StringJoiner(WINNER_SEPARATOR);
        for (Car winner : result.getWinners()) {
            names.add(winner.getName());
        }
        System.out.println(names + WINNER_MESSAGE);
    }
}
