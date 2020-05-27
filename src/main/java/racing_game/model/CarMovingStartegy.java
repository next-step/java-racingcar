package racing_game.model;

public interface CarMovingStartegy {
  /**
   * 차량이 움직일 수 있는지 판단
   * 
   * @param number : int, 판단에 필요한 정수
   * @return
   */
  boolean isCanMove();
}
