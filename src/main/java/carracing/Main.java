package carracing;

import carracing.model.CarRacing;
import carracing.view.InputView;

public class Main {
  public static void main(String[] args) {
    new CarRacing(new InputView()).race(true);
  }
}
