package step3;

import java.util.Map;

public class ResultView {

  private final String MOVED = "-";

  public void showResult(Map<Integer, int[]> result) {
    System.out.println("실행 결과");
    for (int i = 0; i < result.size(); i++) {
      printStep(result.get(i));
    }
  }

  private void printStep(int[] scores) {
    for (int score : scores) {
      System.out.println(MOVED.repeat(score));
    }
    System.out.println();
  }
}
