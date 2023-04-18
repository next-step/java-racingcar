package study.util;

import java.util.Random;

public class RandomizerImpl implements Randomizer{

  Random random = new Random();

  @Override
  public int getRandomValue(int limit) {
    return random.nextInt(limit);
  }
}
