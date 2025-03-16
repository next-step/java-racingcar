package racing.util;

import java.util.List;

public class OutputView {

  public static void showExecutionResultText() {
    System.out.println("실행 결과");
  }

  public static void showLocation(List<Integer> locations) {
    locations.forEach(location -> System.out.println("-".repeat(Math.max(0,location))));
  }

  public static void showWhitespace() {
    System.out.println();
  }
}
