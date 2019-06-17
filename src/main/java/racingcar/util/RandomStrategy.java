package racingcar.util;

import java.util.Random;

public class RandomStrategy implements DrivingStrategy {

  private static DrivingStrategy drivingStrategy;
  private Random random;

  private RandomStrategy() {
    this.random = new Random();
  }

  public static DrivingStrategy getInstance() {
    if (drivingStrategy == null) drivingStrategy = new RandomStrategy();
    return drivingStrategy;
  }

  @Override
  public int throwDice() {
    return this.random.nextInt(10);
  }
}
