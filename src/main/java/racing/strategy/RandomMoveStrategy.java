package racing.strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

  private final Random random;
  private static final int RANDOM_NEXT_INT_BOUND = 10;
  private static final int CAN_MOVE_NUMBER = 4;
  private boolean lastMove;

  public RandomMoveStrategy() {
    this.random = new Random();
  }

  @Override
  public boolean canMove() {
    lastMove = random.nextInt(RANDOM_NEXT_INT_BOUND) >= CAN_MOVE_NUMBER;
    return lastMove;
  }

  public boolean isLastMove() {
    return lastMove;
  }
}
