package racing;

import util.RandomNumberGenerator;

interface MovingStrategy {

  public boolean isMovable();


  public class RandomStrategy implements MovingStrategy {

    public static final int MIN_TO_ALLOW_CAR_MOVE = 4;

    @Override
    public boolean isMovable() {
      return RandomNumberGenerator.generateUnitsDigit() >= MIN_TO_ALLOW_CAR_MOVE;

    }
  }
}
