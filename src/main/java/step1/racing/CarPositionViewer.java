package step1.racing;

import java.util.List;
import java.util.stream.IntStream;

public class CarPositionViewer {
    public static void rendering(List<Integer> carPositions, String flag) {
        carPositions.stream()
                    .map(pos -> IntStream.range(0, pos)
                                     .boxed()
                                     .map(num -> flag)
                                     .reduce(String::concat).get())
                    .forEach(System.out::println);
    }
}
