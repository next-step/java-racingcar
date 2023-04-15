package racingcar.repository;

public interface CarInterface {
  void tryToMove(MoveStrategy moveStrategy);

  int position();
}
