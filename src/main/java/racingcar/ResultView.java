package racingcar;

import java.util.List;

public class ResultView {

  public static final String POSITION_INDICATOR = "-";

  public static void display(Position result) {
    for (int i = 0; i < result.numberOfTimes(); i++) {
      List<Integer> carPosition = result.getCarPosition(i);
      printCarPosition(carPosition);
      printBlankLine();
    }
  }

  private static void printCarPosition(List<Integer> carPosition) {
    for (int i = 0; i < carPosition.size(); i++) {
      print(positionToIndicator(carPosition.get(i)));
    }
  }

  private static void print(String positionToView) {
    System.out.println(positionToView);
  }

  private static String positionToIndicator(int position) {
    String positionView = "";
    for (int i = 0; i < position; i++) {
      positionView += POSITION_INDICATOR;
    }
    return positionView;
  }

  private static void printBlankLine() {
    System.out.println();
  }
}
