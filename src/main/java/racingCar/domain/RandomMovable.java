package racingCar.domain;

import java.util.Random;

/**
 * @author choijaeyong on 2021/03/08.
 * @project java-racingcar
 * @description
 */
public class RandomMovable implements MovableStrategy {
  private static final int RANDOM_NUMBER_BOUNDARY = 10;
  private static final int NUMBER_MOVING_CONDITION = 4;

  private int randomNumber;

  public void createRandomNumber() {
    Random random = new Random();
    this.randomNumber = random.nextInt(RANDOM_NUMBER_BOUNDARY);
  }

  public int getRandomNumber() {
    return this.randomNumber;
  }

  @Override
  public boolean movable() {
    createRandomNumber();
    return this.randomNumber >= NUMBER_MOVING_CONDITION;
  }
}
