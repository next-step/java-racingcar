package racing;

import racing.dto.RacingInput;
import racing.view.RacingInputView;

public class RacingGame {

  public static void main(String[] args) {
    new RacingGame().start();
  }

  private void start() {
    RacingInput racingInput = new RacingInputView().printAndGetRacingInput();
  }

}
