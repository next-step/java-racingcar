package step3;

public class RacingCarMovingStrategy implements CarMovingStartegy {
  private static final int NUMBER_MOVEABLE_MIN = 4;

  /**
   * number가 4 이상일 경우 움직일 수 있다.
   * 
   * @param number : int 판단할 숫자
   * @return boolean, 매개변수 number가 4 이상일 경우 true 반환
   */
  @Override
  public boolean isCanMove() {
    if (NUMBER_MOVEABLE_MIN <= RacingGameUtils.getRandomNumber()) {
      return true;
    }
    return false;
  }

}
