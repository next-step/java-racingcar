package racingcar.random;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
  private static final Random random = new Random(); // Random 인스턴스 생성

  @Override
  public int generateNumber() {
    return random.nextInt(10);
  }
}
