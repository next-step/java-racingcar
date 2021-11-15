package Racing.score;

import Racing.stage.Stage;
import Racing.type.RacingNumber;
import Racing.type.RacingString;

public class Score {

  private final Stage stage;
  private final RacingNumber value;

  public Score(Stage stage) {
    this(stage, RacingNumber.getRandomNumber());
  }

  public Score(Stage stage, RacingNumber value) {
    this.stage = stage;
    this.value = value;
  }

  public RacingString showDisplay() {
    return RacingString.DISPLAY_TOKEN_STRING.repeat(value);
  }
}
