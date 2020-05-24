package racingcar.util;

public class NotUpdatingRandomMovingStrategy extends RandomMovingStrategy {
  int NOT_UPDATING_THRESHOLD = 3;

  @Override
  public boolean isMove() {
    return NOT_UPDATING_THRESHOLD >= UPDATE_POSITION_THRESHOLD;
  }

  public static NotUpdatingRandomMovingStrategy create() {
    return new NotUpdatingRandomMovingStrategy();
  }

}
