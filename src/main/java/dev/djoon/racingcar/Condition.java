package dev.djoon.racingcar;

import java.util.Random;

public enum Condition {

  ALWAYS() {
    @Override
    public int getValue() {
      return 4;
    }
  },
  MANUAL() {
    @Override
    public int getValue() {
      return -2;
    }
  },
  RANDOM() {
    @Override
    public int getValue() {
      Random random = new Random();
      return random.nextInt(boundary);
    }
  },
  RANDOM_SEED_FIXED_TO_10() {
    @Override
    public int getValue() {
      Random random = new Random();
      random.setSeed(10);
      return random.nextInt(boundary);
    }
  };

  protected static int boundary = 10;
  public abstract int getValue();
}
