package racing.domain.strategy;

public class MustNotMoveStrategy implements MoveStrategy {

  @Override
  public boolean canMove() {
    return false;
  }
}
