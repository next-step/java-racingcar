package study.step3;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    public void printResult(List<Integer> cars) {
        for (Integer number : cars) {
            IntStream.range(0, number)
                    .forEach(t -> System.out.print("-"));
            System.out.println();
        }
        System.out.println("End Round");
    }
}
