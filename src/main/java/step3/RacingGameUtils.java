package step3;

import java.util.Random;

public class RacingGameUtils {
  private static final int NUMBER_MOVEABLE_MIN = 4;
  private static final int NUMBER_RANDOM_BOUND = 10;
  private static final Random randomGenerator = new Random();

  private RacingGameUtils() {}

  /**
   * number가 4 이상일 경우 움직일 수 있다.
   * 
   * @param number : int 판단할 숫자
   * @return boolean, 매개변수 number가 4 이상일 경우 true 반환
   */
  public static boolean isCanMove(int number) {
    if (NUMBER_MOVEABLE_MIN <= number) {
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
    return randomGenerator.nextInt(NUMBER_RANDOM_BOUND);
  }
}
