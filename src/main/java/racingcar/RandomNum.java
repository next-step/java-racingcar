package racingcar;

import java.util.Random;

public class RandomNum {

  public int createRandNum() {
    Random random = new Random();
    return random.nextInt(10);
  }
}
