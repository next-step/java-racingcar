package dev.djoon.racingcar;

import java.util.Random;

public enum Condition {

  ALWAYS() {
    @Override
    public boolean isValid() {
      return true;
    }
  },
  NEVER() {
    @Override
    public boolean isValid() {
      return false;
    }
  },
  RANDOM() {
    @Override
    public boolean isValid() {
      Random random = new Random();
      int value = random.nextInt(boundary);

      return isValidValue(value);
    }
  };

  protected static final int boundary = 10;

  public abstract boolean isValid();

  public static boolean isValidValue(int value) {
    return value >= 4;
  }

}
