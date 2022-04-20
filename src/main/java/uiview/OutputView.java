package uiview;

public class OutputView {

  private OutputView() {}

  public static void print(String text, int textRepeatCount) {
    System.out.println(text.repeat(textRepeatCount));
  }

  public static void print(String text) {
    print(text, 0);
  }

  public static void printEmpty() {
    System.out.println("");
  }
}
