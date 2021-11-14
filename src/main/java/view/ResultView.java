package view;

public class ResultView {

  public void printAllCars(int[] moveCounts) {
    for (int moveCount : moveCounts) {
      System.out.println(presentStatus(moveCount));
    }
    System.out.println();
  }

  public String presentStatus(int moveCount) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < moveCount; i++) {
      sb.append("-");
    }

    return sb.toString();
  }
}
