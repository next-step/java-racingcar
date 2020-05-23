package racingcar.util;

public class RandomMovingStrategy implements MovingStrategy {
  static int UPDATE_POSITION_THRESHOLD = 4;

  @Override
  public boolean isMove() {
    return RandomUtil.getRandomValue() >= UPDATE_POSITION_THRESHOLD;
  }

  public static RandomMovingStrategy create() {
    return new RandomMovingStrategy();
  }
}
