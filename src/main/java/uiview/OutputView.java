package uiview;

public class OutputView {

  private OutputView() {}


  public static void print(String text, int textRepeatCount) {
    System.out.println(text.repeat(textRepeatCount));
  }

  public static void print(String text) {
    print(text, 1);
  }

  public static void printEmpty() {
    System.out.println("");
  }
}
