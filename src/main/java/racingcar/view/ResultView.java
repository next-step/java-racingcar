package racingcar.view;

import racingcar.PositiveInteger;
import racingcar.dto.RoundResult;

import java.util.List;

public final class ResultView {

    private ResultView() {
        throw new AssertionError();
    }

    public static void print(List<RoundResult> roundResults) {
        for (RoundResult roundResult : roundResults) {
            printStates(roundResult.getStates());
        }
    }

    public static void printStates(List<PositiveInteger> states) {
        StringBuilder sb = new StringBuilder();
        for (PositiveInteger state : states) {
            sb.append("|");
            for (int i = 0; i < state.value(); i++) {
                sb.append("-");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
