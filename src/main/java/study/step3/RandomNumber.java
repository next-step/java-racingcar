package study.step3;

import java.util.Random;

public class RandomNumber {

  public static int generator() {
    Random random = new Random();
    return random.nextInt(10);
  }

}
