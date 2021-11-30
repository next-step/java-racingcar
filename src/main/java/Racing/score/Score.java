package Racing.score;

import Racing.stage.Stage;
import Racing.type.RacingNumber;

public class Score {

  private final Stage stage;
  private final RacingNumber value;
  private static final RacingNumber MIN_VALUE = new RacingNumber(4);

  public Score(Stage stage) {
    this(stage, RacingNumber.getRandomNumber());
  }

  public Score(Stage stage, RacingNumber value) {
    this.stage = stage;
    this.value = getValue(value);
  }

  private RacingNumber getValue(RacingNumber value) {
    if (value.isBiggerThan(MIN_VALUE)) {
      return RacingNumber.ZERO;
    }
    return value;
  }

  public RacingNumber getDistance() {
    return value;
  }

  public boolean isSameStage(Stage stage) {
    return this.stage.equals(stage);
  }
}
