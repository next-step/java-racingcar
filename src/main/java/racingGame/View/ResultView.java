package racingGame.View;

import java.util.List;
import javafx.util.Pair;

public class ResultView {

  private static final String RESULT_MESSAGE = "실행 결과";
  private static final String NAME_SCORE_DELIMITER = ": ";
  private static final String WINNERS_NAME_DELIMITER = ",";
  private static final String SCORE_CHARACTER = "-";

  private ResultView() {
  }

  static public void printResultMessage() {
    System.out.println(RESULT_MESSAGE);
  }

  public static void printCurrentStatus(List<Integer> positions) {
    for (Integer position : positions) {
      printDash(position);
    }
    System.out.println();
  }

  public static void printCurrentStatusWithName(List<Pair<String, Integer>> nameAndPosition) {
    for (Pair<String, Integer> position : nameAndPosition) {
      System.out.print(position.getKey());
      System.out.print(NAME_SCORE_DELIMITER);
      printDash(position.getValue());
    }
    System.out.println();
  }

  static private void printDash(int numDash) {
    for (int i = 0; i < numDash; i++) {
      System.out.print(SCORE_CHARACTER);
    }
    System.out.println();
  }

  static public void printWinner(List<String> winners) {
    System.out.print(winners.get(0));
    for (int i = 1; i < winners.size(); i++) {
      System.out.print(WINNERS_NAME_DELIMITER);
      System.out.print(winners.get(i));
    }
    System.out.println("이(가) 최종 우승했습니다.");
  }
}
