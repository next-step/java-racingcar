package racingcar;

import java.util.stream.IntStream;

public class ResultView {
    public static void printMovement(int movementCount) {
        IntStream.range(0,movementCount)
                .forEach(i -> System.out.print("-"));
        System.out.println("");
    }
}
