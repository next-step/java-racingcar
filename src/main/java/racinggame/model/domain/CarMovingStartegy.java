package racinggame.model.domain;

public interface CarMovingStartegy {

  /**
   * 차량이 움직일 수 있는지 판단
   *
   * @return boolean, 이동 가능 여부
   */
  boolean isCanMove();
}
