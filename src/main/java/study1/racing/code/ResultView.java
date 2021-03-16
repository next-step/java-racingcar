package study1.racing.code;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {
  private static final String RUN_MARK = "-";

  public static void print(List<Integer> distances) {
    distances.stream().forEach(ResultView::printMinus);
    System.out.print("\n");
  }

  public static void printMinus(int num) {
    IntStream.range(0, num).forEach((i) -> System.out.print(RUN_MARK));
    System.out.print("\n");
  }
}
