package racing.view;

public class OutputView {

  public static void print() {
    System.out.println();
  }

  public static void print(String message) {
    System.out.println(message);
  }

  public static void printNumberToDash(int number) {
    for (int i = 0; i < number; i++) {
      System.out.print("-");
    }
    print();
  }

}
