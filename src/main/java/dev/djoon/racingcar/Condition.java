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
      int value = random.nextInt(BOUNDARY_VALUE);

      return isValidValue(value);
    }
  },
  RANDOM_SEED_FIXED_TO_10() {
    /** 랜덤값 대신 고정값을 주기 위해 만든 테스트용 조건 **/
    @Override
    public boolean isValid() {
      Random random = new Random();
      random.setSeed(10);
      int value = random.nextInt(BOUNDARY_VALUE);

      for (int i=0; i<round; i++)
        value = random.nextInt(BOUNDARY_VALUE);
      round++;

      return isValidValue(value);
    }
  };

  protected static final int BOUNDARY_VALUE = 10;
  protected static final int VALID_VALUE = 4;

  public static int round = 0; /** 테스트용 변수 **/

  public abstract boolean isValid();

  public static boolean isValidValue(int value) {
    return value >= VALID_VALUE;
  }

}
