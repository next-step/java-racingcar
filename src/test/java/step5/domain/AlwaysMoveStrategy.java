package step5.domain;

public class AlwaysMoveStrategy implements MoveStrategy {

  private static MoveStrategy instance;

  private AlwaysMoveStrategy () {};

  @Override
  public boolean isMoved() {
    return true;
  }

  @Override
  public boolean isMoved(int number) {
    return true;
  }

  public static MoveStrategy getInstance () {
    if (instance == null) instance = new AlwaysMoveStrategy();
    return instance;
  }
}
