package racing.view;

import java.util.List;

public class ResultView {

  public static final String RESULT_START_MESSAGE = "실행 결과";
  public static final String CAR_TRACE = "-";

  public static void printResultTitle() {
    System.out.println(RESULT_START_MESSAGE);
  }

  public static void printTurnResult(List<Integer> locations) {
    for (int location : locations) {
      System.out.println(CAR_TRACE.repeat(location));
    }
    System.out.println();
  }
}
