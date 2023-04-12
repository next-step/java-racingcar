package racing.util;

import java.util.Random;

/**
 * 랜덤 숫자 생성기 (RandomNumberGenerator)
 *     - 책임
 *       - 0에서 9 사이의 랜덤 값을 생성한다.
 *
 * private 생성자를 사용하는 이유는
 * 1. 외부에서 객체를 생성하지 못하도록 하기 위해서
 */
public class RandomNumberGenerator {

  private static final Random random;

  private RandomNumberGenerator() {
  }

  static {
    random = new Random();
  }

  public static int generate() {
    return random.nextInt(10);
  }


}
