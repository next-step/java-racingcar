package study.racing;

public class ResultView {

  public static void printResult(int moveCount) {
    System.out.println(getMoveCountPrint(moveCount));
  }

  private  static String getMoveCountPrint(int moveCount) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < moveCount; i++) {
      builder.append("_");
    }
    return builder.toString();
  }

}
