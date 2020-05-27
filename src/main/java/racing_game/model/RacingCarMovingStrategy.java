package racing_game.model;

public class RacingCarMovingStrategy implements CarMovingStartegy {

  private static final int NUMBER_MOVEABLE_MIN = 4;

  /**
   * 무작위 수를 구하여 4 이상일 경우 움직일 수 있다.
   *
   * @return boolean, 매개변수 number가 4 이상일 경우 true 반환
   */
  @Override
  public boolean isCanMove() {
    return NUMBER_MOVEABLE_MIN <= RacingGameUtils.getRandomNumber();
  }
}
