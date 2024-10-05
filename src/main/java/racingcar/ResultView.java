package racingcar;

import java.util.List;

public class ResultView {
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private static final String CAR_POSITION_MARKER = "-";
    public static final String WINNER_ANNOUNCEMENT_MESSAGE = "가 최종 우승했습니다.";

    private ResultView() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static void printHistory(RaceResult raceResult, List<Car> winners) {
        StringBuilder result = new StringBuilder();
        result.append("\n").append(EXECUTION_RESULT_MESSAGE).append("\n");
        for (AttemptResult attemptResult : raceResult.getAttemptResults()) {
            appendPosition(attemptResult, result);
        }
        appendWinners(winners, result);
        System.out.print(result);
    }

    private static void appendWinners(List<Car> winners, StringBuilder result) {
        for (int i = 0; i < winners.size(); i++) {
            result.append(winners.get(i).getName());
            if (i != winners.size() - 1) {
                result.append(", ");
            }
        }
        result.append(WINNER_ANNOUNCEMENT_MESSAGE);
    }

    private static void appendPosition(AttemptResult attemptResult, StringBuilder result) {
        for (Car car : attemptResult.getCars()) {
            result.append(car.getName()).append(" : ").append(CAR_POSITION_MARKER.repeat(Math.max(0, car.getPosition()))).append("\n");
        }
        result.append("\n");
    }
}
