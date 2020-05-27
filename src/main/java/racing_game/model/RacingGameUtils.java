package racing_game.model;

import java.util.Random;

public class RacingGameUtils {
//  private static final int NUMBER_MOVEABLE_MIN = 4;
  private static final int NUMBER_RANDOM_BOUND = 10;
  private static final Random randomGenerator = new Random();

  private RacingGameUtils() {}

  /**
   * 0에서 9 까지 무작위 정수 생성
   * 
   * @return 생성된 숫자
   */
  public static int getRandomNumber() {
    return randomGenerator.nextInt(NUMBER_RANDOM_BOUND);
  }
}
