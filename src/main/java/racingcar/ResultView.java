package racingcar;

import java.util.List;

public class ResultView {
    private static final String EXECUTE_RESULT = "실행 결과";
    private static final String FORWARD = "-";

    private ResultView() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static void printHistory(RaceResult raceResult, List<Car> winners) {
        StringBuilder result = new StringBuilder();
        result.append("\n" + EXECUTE_RESULT + "\n");
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
        result.append("가 최종 우승했습니다.");
    }

    private static void appendPosition(AttemptResult attemptResult, StringBuilder result) {
        for (Car car : attemptResult.getCars()) {
            result.append(car.getName()).append(" : ").append(FORWARD.repeat(Math.max(0, car.getPosition()))).append("\n");
        }
        result.append("\n");
    }
}
