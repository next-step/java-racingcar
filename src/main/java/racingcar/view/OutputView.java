package racingcar.view;

import racingcar.domain.GameResult;
import racingcar.domain.PhaseResult;

public class OutputView {
    private static final String MARK = "-";
    private OutputView() {
    }

    public static void printGameResult(GameResult gameResult) {
        int numberOfPhase = gameResult.getNumberOfPhase();
        System.out.println("실행 결과");

        for (int i = 1; i <= numberOfPhase; i++) {
            printPhaseResult(gameResult.findByPhaseNumber(i), i);
            System.out.println();
        }

    }

    public static void printPhaseResult(PhaseResult phaseResult, int phase) {
        System.out.println("시도 번호 - " + phase);
        phaseResult.getRaceResult().stream()
                .map(OutputView::visualizeLocation)
                .forEach(System.out::println);
    }

    private static String visualizeLocation(int location) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < location; i++) {
            builder.append(MARK);
        }

        return builder.toString();
    }
}
