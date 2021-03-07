package dev.djoon.racingcar.util;

import java.util.Random;

public class RandomNumbers {
  protected final Random random = new Random();

  public int nextInt(GameConstant bound) {
    return random.nextInt(bound.value());
  }

  public void setSeed(GameConstant seed) {
    random.setSeed(seed.value());
  }
}
