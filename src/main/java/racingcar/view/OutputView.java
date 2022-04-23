package racingcar.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private OutputView() {
    }

    private static final String RESULT_GUIDE = "실행 결과";
    private static final String COMMA_DELIMITER = ", ";
    private static final String COLON_DELIMITER = " : ";
    private static final String END_LINE = "\n";
    private static final String UNIT_DISTANCE = "-";
    private static final String WINNER_GUIDE = "가 최종 우승했습니다.";

    public static void guide() {
        System.out.println(END_LINE + RESULT_GUIDE);
    }

    public static void printRacingResult(Map<String, Integer> carMap) {
        for (Map.Entry<String, Integer> entry : carMap.entrySet()) {
            System.out.printf(entry.getKey() + COLON_DELIMITER + UNIT_DISTANCE.repeat(entry.getValue()) + END_LINE);
        }
        System.out.printf(END_LINE);
    }

    public static void printWinners(List<String> winners) {
        System.out.println(getWinners(winners) + WINNER_GUIDE);
    }

    private static String getWinners(List<String> winners) {
        return winners.stream().collect(Collectors.joining(COMMA_DELIMITER));
    }

}
