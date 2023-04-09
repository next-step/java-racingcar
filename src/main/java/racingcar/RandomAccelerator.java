package racingcar;

import java.util.Random;

public class RandomAccelerator implements Accelerator {

  private final Random random = new Random();

  @Override
  public int accelerate() {
    return this.random.nextInt(10);
  }
}
