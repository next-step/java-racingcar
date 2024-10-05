package racingcar;

import java.util.List;

public class ResultView {
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private static final String CAR_POSITION_MARKER = "-";
    public static final String WINNER_ANNOUNCEMENT_MESSAGE = "가 최종 우승했습니다.";
    public static final String LINE_SEPARATOR = System.lineSeparator();

    private ResultView() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static void printHistory(RaceResult raceResult, List<Car> winners) {
        StringBuilder result = new StringBuilder();
        result.append(LINE_SEPARATOR).append(EXECUTION_RESULT_MESSAGE).append(LINE_SEPARATOR);
        for (AttemptResult attemptResult : raceResult.getAttemptResults()) {
            appendPosition(attemptResult, result);
        }
        appendWinners(winners, result);
        System.out.print(result);
    }

    private static void appendWinners(List<Car> winners, StringBuilder result) {
        for (int i = 0; i < winners.size(); i++) {
            result.append(winners.get(i).getName()).append(getCommaIfNotLast(winners, i));
        }
        result.append(WINNER_ANNOUNCEMENT_MESSAGE);
    }

    private static String getCommaIfNotLast(List<Car> winners, int i) {
        if (i != winners.size() - 1) {
            return ", ";
        }
        return "";
    }

    private static void appendPosition(AttemptResult attemptResult, StringBuilder result) {
        for (Car car : attemptResult.getCars()) {
            result.append(car.getName()).append(" : ").append(CAR_POSITION_MARKER.repeat(Math.max(0, car.getPosition()))).append(LINE_SEPARATOR);
        }
        result.append(LINE_SEPARATOR);
    }
}
