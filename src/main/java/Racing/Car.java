package Racing;

import java.util.Random;

public class Car {


  static final private int RANDOM_BOUND = 10;

  private ScoreList score;

  public Car() {
    score = new ScoreList();
  }

  public Car move() {
    distance += getRandomToken();
    return this;
  }

  public String presentDistance() {
    return TOKEN.repeat(this.distance);
  }

  private int getRandomToken() {
    return new Random().nextInt(RANDOM_BOUND) + 1;
  }
}
