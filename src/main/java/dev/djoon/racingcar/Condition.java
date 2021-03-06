package dev.djoon.racingcar;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

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
  },
  RANDOM_SEED_FIXED_TO_10() {
    /** 랜덤값 대신 고정값을 주기 위해 만든 테스트용 조건 **/
    @Override
    public boolean isValid() {
      Random random = new Random();
      random.setSeed(10);
      int value = random.nextInt(boundary);

      for (int i=0; i<round; i++)
        value = random.nextInt(boundary);
      round++;

      return isValidValue(value);
    }
  };

  public static int round = 0; /** 테스트용 변수 **/
  protected static final int boundary = 10;

  public abstract boolean isValid();

  public static boolean isValidValue(int value) {
    return value >= 4;
  }

}
