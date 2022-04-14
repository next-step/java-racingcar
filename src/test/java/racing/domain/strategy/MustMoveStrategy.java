package racing.domain.strategy;

public class MustMoveStrategy implements MoveStrategy {

  @Override
  public boolean canMove() {
    return true;
  }
}
