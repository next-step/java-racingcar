package dev.djoon.racingcar.util;

import java.util.Random;

public class RandomNumbers {
  protected final Random random = new Random();

  public int nextInt(int bound) {
    return random.nextInt(bound);
  }

  public void setSeed(long seed) {
    random.setSeed(seed);
  }
}
