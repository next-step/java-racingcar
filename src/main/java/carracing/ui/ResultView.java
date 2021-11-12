package carracing.ui;

public class ResultView {

  private static ResultView instance;

  private ResultView() {}

  public static ResultView getInstance() {
    if (instance == null) {
      return new ResultView();
    }
    return instance;
  }

  public void printMessage(String message) {
    System.out.println(message);
  }

}
