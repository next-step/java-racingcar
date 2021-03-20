package study1.winner.code.common;

import java.util.List;
import java.util.stream.IntStream;

import study1.winner.code.dto.ResultData;

public class ResultView {
  private static final String RUN_MARK = "-";
  private static final int INIT_NUM = 0;

  public static void result(List<ResultData> list) {
    list.stream()
      .forEach((resultData) -> {
        System.out.print(resultData.name() + ": ");
        print(resultData.distance());
      });
    System.out.println(System.lineSeparator());
  }

  public static void print(List<Integer> distances) {
    distances.stream().forEach(ResultView::print);
  }

  public static void print(int num) {
    IntStream.range(INIT_NUM, num).forEach((i) -> System.out.print(RUN_MARK));
    System.out.println(System.lineSeparator());
  }

  public static void winner(List<String> winners) {
    System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
  }
}
