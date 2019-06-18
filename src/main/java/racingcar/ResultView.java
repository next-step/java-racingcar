package racingcar;

import java.util.List;

public class ResultView {

  public static final String POSITION_INDICATOR = "-";

  public static void display(Record record) {
    List<Position> positions = record.getRecord();
    for (int i = 0; i < positions.size(); i++) {
      Position position = positions.get(i);
      printPosition(position);
    }
  }

  private static void printPosition(Position position) {
    List<Integer> carPosition = position.getCarPosition();
    printCarPosition(carPosition);
    printBlankLine();
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
