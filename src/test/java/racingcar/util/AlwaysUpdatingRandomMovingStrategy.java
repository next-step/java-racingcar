package racingcar.util;

public class AlwaysUpdatingRandomMovingStrategy extends RandomMovingStrategy {
  int ALWAYS_UPDATING_THRESHOLD = 5;

  @Override
  public boolean isMove() {
    return ALWAYS_UPDATING_THRESHOLD >= UPDATE_POSITION_THRESHOLD;
  }

  public static AlwaysUpdatingRandomMovingStrategy create() {
    return new AlwaysUpdatingRandomMovingStrategy();
  }

}
