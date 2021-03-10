package study1.racing;

import java.util.stream.IntStream;

public class ResultView {
  public static void print(int num) {
    IntStream.range(0, num).forEach((i) -> System.out.print("-"));
    System.out.print("\n");
  }
}
