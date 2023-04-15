package racingcar.repository;

public interface CarInterface {
  public void move(MoveStrategy moveStrategy);

  public int position();
}
