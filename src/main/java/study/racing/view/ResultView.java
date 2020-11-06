package study.racing.view;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    public void printResult(List<Integer> carRecords) {
        for (Integer number : carRecords) {
            IntStream.range(0, number)
                    .forEach(t -> System.out.print("-"));
            System.out.println();
        }
        System.out.println("End Round");
    }
}
