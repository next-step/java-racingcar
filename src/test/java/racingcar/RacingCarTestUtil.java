package racingcar;

import java.util.stream.IntStream;

public class RacingCarTestUtil {
    public static final int NUM_OF_TRAIALS = 5;
    public static final int NUM_OF_CARS = 5;

    public static String getMaxProgress() {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, NUM_OF_TRAIALS)
                .forEach( i ->
                        sb.append('-')
                );
        return sb.toString();
    }
}
