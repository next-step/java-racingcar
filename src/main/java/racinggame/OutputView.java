package racinggame;

import java.util.Arrays;
import java.util.stream.Collectors;

public class OutputView {

    private static final String DISTANCE_SYMBOL = "-";
    private static final String NEW_LINE = "\n";

    public void printResult(int[][] result) {
        System.out.println("실행 결과");
        System.out.println(Arrays.stream(result)
                .map(this::joinRound)
                .collect(Collectors.joining(NEW_LINE.repeat(2))));
    }

    private String joinRound(int[] round) {
        return Arrays.stream(round)
                .mapToObj(DISTANCE_SYMBOL::repeat)
                .collect(Collectors.joining(NEW_LINE));
    }

}
