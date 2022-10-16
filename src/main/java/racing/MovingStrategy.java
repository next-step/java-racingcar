package racing;

import util.RandomNumberGenerator;

interface MovingStrategy {

  public boolean isMovable();


  public class RandomMovingStrategy implements MovingStrategy {

    public static final int MIN_TO_ALLOW_CAR_MOVE = 4;

    @Override
    public boolean isMovable() {
      return RandomNumberGenerator.generateUnitsDigit() >= MIN_TO_ALLOW_CAR_MOVE;
    }
  }

  public class AlwaysMovingStrategy implements MovingStrategy {

    @Override
    public boolean isMovable() {
      return true;
    }
  }

  public class NeverMovingStrategy implements MovingStrategy {

    @Override
    public boolean isMovable() {
      return false;
    }
  }
}
