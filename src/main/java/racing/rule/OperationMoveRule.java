package racing.rule;

import java.util.Random;

public class OperationMoveRule implements MoveRule {

  public static final int LIMIT_RANDOM_NUMBER = 10;
  public static final int MORE_THAN_NUMBER_FOR_CAR_MOVE = 4;

  @Override
  public boolean possibleMove() {
    return randomNumber() >= MORE_THAN_NUMBER_FOR_CAR_MOVE;
  }

  private int randomNumber() {
    return new Random().nextInt(LIMIT_RANDOM_NUMBER);
  }
}
