package racingcar.strategy;

public class FixedFalseMovingStrategy implements MovingStrategy {

  @Override
  public boolean decideWhetherToMove() {
    return false;
  }
}
