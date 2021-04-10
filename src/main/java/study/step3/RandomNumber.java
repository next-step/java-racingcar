package study.step3;

import java.util.Random;

public class RandomNumber {

  private static final int RANDOM_SIZE = 10;

  public static int generator() {
    Random random = new Random();
    return random.nextInt(RANDOM_SIZE);
  }

}
