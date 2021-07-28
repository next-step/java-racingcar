package study.racing.strategy;

public class CarMovableStrategy implements MoveStrategy{

  private static final int LIMIT_NUMBER = 4;

  @Override
  public boolean movable(int targetNumber) {
    return targetNumber >= LIMIT_NUMBER;
  }
}