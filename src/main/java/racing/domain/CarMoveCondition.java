package racing.domain;

/**
 * 자동차 이동 조건 (CarMoveCondition) - 책임 - 랜덤 생성기의 임의 값을 기반으로 Car 객체의 움직임을 제어. - Car 객체가 앞으로 이동해야 하는지
 * 정지해야 하는지 결정합니다.
 */
public class CarMoveCondition {

  private static final int MOVE_CONDITION = 4;

  public static boolean isMove(int randomNumber) {
    return randomNumber >= MOVE_CONDITION;
  }

  private CarMoveCondition() {
  }

}
