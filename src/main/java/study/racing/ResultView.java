package study.racing;

public final class ResultView {

  private static final String MOVE_MARK = "_";

  public static void printPosition(int position) {
    System.out.println(positionToString(position));
  }

  public static String positionToString(int position) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < position; i++) {
      builder.append(MOVE_MARK);
    }
    return builder.toString();
  }

}
