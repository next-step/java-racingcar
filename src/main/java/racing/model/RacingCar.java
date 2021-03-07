package racing.model;

public class RacingCar {

  private int position;

  public RacingCar(int position) {
    this.position = position;
  }

  /**
   * 자동차 위치를 알려주는 메서드
   */
  public int getPosition() {
    return position;
  }

  /**
   * 자동차 위치를 이동시켜주는 메서드
   */
  public int move(int moveCount) {
    if (isForward(moveCount)) {
      this.position += moveCount;
    }
    return position;
  }

  /**
   * 이동 거리가 4이상인지 판단하는 메서드
   */
  public boolean isForward(int moveCount) {
    return moveCount > 3;
  }
}
