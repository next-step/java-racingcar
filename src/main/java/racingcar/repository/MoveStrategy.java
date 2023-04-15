package racingcar.repository;

public interface MoveStrategy {

  boolean decideMoveOrHold();

  int moveForward();
}
