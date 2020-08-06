package com.cspark.nextstep.step3.domain;

import java.util.Random;

public class Dice {

  private static final Random random = new Random();
  private final int min;
  private final int max;

  public Dice(int min, int max) {
    this.min = min;
    this.max = max;
  }

  public int cast() {
    return random.ints(min, max)
        .findFirst()
        .getAsInt();
  }
}
