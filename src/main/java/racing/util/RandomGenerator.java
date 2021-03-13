package racing.util;

import java.util.Random;

public class RandomGenerator implements Generator{
  private static final int BOUND_VALUE = 10;
  private final Random random;

  public RandomGenerator(){
    this.random = new Random();
  }

  public int generate() {
    // 실행 시점을 기준으로 Seed 사용
    return random.nextInt(BOUND_VALUE);
  }
}