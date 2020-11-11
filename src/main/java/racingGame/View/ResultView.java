package racingGame.View;

import java.util.List;
import javafx.util.Pair;

public class ResultView {

  private static final String RESULT_MESSAGE = "실행 결과";
  private static final String NAME_SCORE_DELIMITER = ": ";
  private static final String WINNERS_NAME_DELIMITER = ",";
  private static final String SCORE_CHARACTER = "-";
  private static final String CLOSING_COMMENTS = "이(가) 최종 우승했습니다.";

  private ResultView() {
  }

  public static void printResultMessage() {
    System.out.println(RESULT_MESSAGE);
  }

  public static void printCurrentStatus(List<Integer> positions) {
    for (Integer position : positions) {
      printDash(position);
    }
    splitLine();
  }

  public static void printCurrentStatusWithName(List<Pair<String, Integer>> nameAndPosition) {
    for (Pair<String, Integer> position : nameAndPosition) {
      printNameWithDelimiter(position.getKey());
      printDash(position.getValue());
    }
    splitLine();
  }

  private static void printNameWithDelimiter(String key) {
    System.out.print(key);
    System.out.print(NAME_SCORE_DELIMITER);
  }

  private static void printDash(int numDash) {
    for (int i = 0; i < numDash; i++) {
      System.out.print(SCORE_CHARACTER);
    }
    splitLine();
  }

  public static void printWinner(List<String> winners) {
    System.out.print(winners.get(0));
    for (int i = 1; i < winners.size(); i++) {
      printSplitterAndName(winners.get(i));
    }
    System.out.println(CLOSING_COMMENTS);
  }

  private static void printSplitterAndName(String name) {
    System.out.print(WINNERS_NAME_DELIMITER);
    System.out.print(name);
  }

  private static void splitLine() {
    System.out.println();
  }
}
