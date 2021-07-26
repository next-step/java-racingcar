package study.racing.generator;

import java.util.Random;

public class RandomGenerator implements Generator{

  private static final Random random = new Random();

  private static final int RANDOM_MAX_NUMBER = 10;

  public int generateNewNumber(){
    return random.nextInt(RANDOM_MAX_NUMBER);
  }
}
