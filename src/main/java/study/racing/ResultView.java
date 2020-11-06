package study.racing;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    public void printResult(int round, List<Integer> cars) {
        for (Integer number : cars) {
            IntStream.range(0, number)
                    .forEach(t -> System.out.print("-"));
            System.out.println();
        }
        System.out.printf("End %d Round\n", round);
    }
}
