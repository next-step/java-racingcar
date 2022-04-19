package uiview;

public class OutputView {

  public void print(String text, int textRepeatCount) {
    System.out.println(text.repeat(textRepeatCount));
  }

  public void print(String text) {
    print(text, 0);
  }

  public void printEmpty() {
    System.out.println("");
  }
}
