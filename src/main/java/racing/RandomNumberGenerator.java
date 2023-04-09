package racing;

import java.util.Random;

/**
 * 랜덤 숫자 생성기 (RandomNumberGenerator)
 *     - 책임
 *       - 0에서 9 사이의 랜덤 값을 생성한다.
 */
public class RandomNumberGenerator {

  private final Random random;

  public RandomNumberGenerator() {
    this.random = new Random();
  }

  public int generate() {
    return random.nextInt(10);
  }


}
