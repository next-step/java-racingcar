package racingcar.view;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    public static String printMovement(int movementCount) {
        String result = IntStream.range(0, movementCount)
                .mapToObj(i -> "-")
                .collect(Collectors.joining());

        System.out.println(result);

        return result;
    }
}
