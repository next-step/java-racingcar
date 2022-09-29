package racing_game.core;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import racing_game.view.InputView;

public class RacingGame {

  public void run() {
    try {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      InputView inputView = InputView.create("자동차 대수는 몇 대 인가요?", br);
      int result = inputView.getNumberInput();

    } catch (Exception e) {
      System.out.println("the game error occurred");
      e.printStackTrace();
    }
  }
}
