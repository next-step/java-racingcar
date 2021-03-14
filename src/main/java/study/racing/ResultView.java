package study.racing;

import java.util.List;

public final class ResultView {

  private static final String MOVE_MARK = "_";
  private static final String WINNER_MESSAGE_FORMAT = "%s 가 최종 우승했습니다.";

  public static void printPosition(String name, int position) {
    String result = String.format("%s : %s", name, positionToString(position));
    System.out.println(result);
  }

  public static String positionToString(int position) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < position; i++) {
      builder.append(MOVE_MARK);
    }
    return builder.toString();
  }

  public static void printWinner(String winnerNames) {
    String winnerMessage = String.format(WINNER_MESSAGE_FORMAT, winnerNames);
    System.out.println(winnerMessage);
  }

}
