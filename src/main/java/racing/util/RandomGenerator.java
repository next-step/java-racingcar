package racing.util;

import java.util.Random;

public class RandomGenerator {
  public static int createRandomValue(){
    // 실행 시점을 기준으로 Seed 사용
    Random random = new Random();
    return random.nextInt(10);
  }
}
