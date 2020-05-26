package step3;

public class RacingGameUtils {
  private static final int MIN_MOVEABLE_NUMBER = 4;

  private RacingGameUtils() {}

  /**
   * number가 4 이상일 경우 움직일 수 있다.
   * 
   * @param number : int 판단할 숫자
   * @return boolean, 매개변수 number가 4 이상일 경우 true 반환
   */
  public static boolean isCanMove(int number) {
    if (MIN_MOVEABLE_NUMBER <= number) {
      return true;
    }
    return false;
  }

  /**
   * 0에서 9 까지 무작위 정수 생성
   * 
   * @return 생성된 숫자
   */
  public static int getRandomNumber() {
    return (int) (Math.random() * 10);
  }
}
