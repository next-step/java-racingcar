package racingcar.view;

import racingcar.PositiveInteger;

import java.util.List;

public class ResultView {

    private ResultView() {
        throw new AssertionError();
    }

    public static void print(List<PositiveInteger> states) {
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
