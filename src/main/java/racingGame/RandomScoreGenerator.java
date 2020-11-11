package racingGame;

import java.util.Random;

public class RandomScoreGenerator implements ScoreGenerator {

  private static final int RANDOM_RANGE = 10;
  private static final int THRESHOLD = 4;
  private static final int GO = 1;
  private static final int STAY = 0;

  private final Random rawValueGenerator;

  public RandomScoreGenerator() {
    this.rawValueGenerator = new Random();
  }

  public RandomScoreGenerator(long seed) {
    this();
    rawValueGenerator.setSeed(seed);
  }

  @Override
  public int generateScore() {
    return rawValueGenerator.nextInt(RANDOM_RANGE) > THRESHOLD ? GO : STAY;
  }

}
