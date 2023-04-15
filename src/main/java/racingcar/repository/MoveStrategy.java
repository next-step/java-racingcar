package racingcar.repository;

public interface MoveStrategy {
  public final int DEFAULT_CAR_MOVEMENT_STANDARD = 4;   // random 값이 4이상인 경우 전진
  public final int DEFAULT_MOVEMENT_DISTANCE = 1;     // 자동차 이동 시 1만큼 전진

  public boolean decideMoveOrHold();

  public int moveForward();
}
