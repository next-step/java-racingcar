package camp.nextstep.racingcar.domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

  private static Random random = new Random();

  @Override
  public int generate() {
    return random.nextInt(10);
  }
}
