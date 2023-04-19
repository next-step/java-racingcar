package racing.view;

public class OutputView {

  public static void printNumberToDash(int number) {
    for (int i = 0; i < number; i++) {
      System.out.print("-");
    }
    System.out.println();
  }

}
