package step1.racing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Preparation {
    public static List<Integer> initRacingGame(int players) {
        return IntStream.range(0, players)
                        .map(num -> 1)
                        .boxed()
                        .collect(Collectors.toList());
    }
}
