package step3.view;

public class ResultView {

  public void printPosition(int position) {
    for (int i = 0; i < position; i++) {
      System.out.print("-");
    }
    System.out.println();
  }
}
