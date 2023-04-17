package racingcar.strategy;

public interface CarInterface {
  void tryToMove(MoveStrategy moveStrategy);

  int position();
}
