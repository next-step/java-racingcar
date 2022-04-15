package racingcar.view;

import racingcar.model.Distance;
import racingcar.dto.RoundResult;

import java.util.List;

public final class ResultView {
    public static final String START_LINE = "|";
    public static final String CAR_STATE = "-";
    public static final String NEW_LINE = System.lineSeparator();

    private ResultView() {
        throw new AssertionError();
    }

    public static void print(List<RoundResult> roundResults) {
        for (RoundResult roundResult : roundResults) {
            printStates(roundResult.getStates());
        }
    }

    public static void printStates(List<Distance> states) {
        StringBuilder sb = new StringBuilder();
        for (Distance state : states) {
            sb.append(START_LINE);
            for (int i = 0; i < state.value(); i++) {
                sb.append(CAR_STATE);
            }
            sb.append(NEW_LINE);
        }
        System.out.println(sb);
    }
}
