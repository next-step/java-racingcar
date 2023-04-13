package racingcar.application;

import java.util.Random;

public class RandomAccelerator implements Accelerator {

  private static final Random random = new Random();

  @Override
  public int accelerate() {
    return this.random.nextInt(10);
  }
}
