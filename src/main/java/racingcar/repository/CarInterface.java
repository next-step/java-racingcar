package racingcar.repository;

public interface CarInterface {
  public void tryToMove(MoveStrategy moveStrategy);

  public int position();
}
