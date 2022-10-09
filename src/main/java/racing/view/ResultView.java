package racing.view;

import java.util.List;

public class ResultView {

  public static final String CAR_TRACE = "-";

  public static void printResult(List<Integer> locations) {
    for (int location : locations) {
      System.out.println(CAR_TRACE.repeat(location));
    }
  }

}
