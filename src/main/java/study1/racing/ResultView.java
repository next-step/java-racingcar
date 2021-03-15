package study1.racing;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {
  public static void print(List<Integer> distances) {
    distances.stream().forEach(ResultView::printMinus);
    System.out.print("\n");
  }

  public static void printMinus(int num) {
    IntStream.range(0, num).forEach((i) -> System.out.print("-"));
    System.out.print("\n");
  }
}
