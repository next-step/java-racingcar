package study.racingcar.factory;

import java.util.Random;
import study.racingcar.domain.RandomInt;

public class RandomIntFactory {

  public static final int DEFAULT_START_BOUND = 0;
  public static final int DEAFULT_END_BOUND = 10;
  private static final Random RANDOM_INSTANCE = new Random();

  private final int startBound;
  private final int endBound;

  public RandomIntFactory() {
    this(DEFAULT_START_BOUND, DEAFULT_END_BOUND);
  }

  public RandomIntFactory(int startBound, int endBound) {
    if (startBound < DEFAULT_START_BOUND || endBound > DEAFULT_END_BOUND) {
      throw new IllegalArgumentException("유효한 값이 아닙니다.");
    }
    this.startBound = startBound;
    this.endBound = endBound;
  }

  public RandomInt createRandomInt() {
    return new RandomInt(this.startBound + RANDOM_INSTANCE.nextInt(endBound - startBound));
  }
}
