package step3;

public class AlwaysMoveStrategy implements MoveStrategy {
  @Override
  public boolean isMoved() {
    return true;
  }

  @Override
  public boolean isMoved(int number) {
    return true;
  }
}
