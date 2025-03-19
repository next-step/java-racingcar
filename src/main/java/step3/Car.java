package step3;

public class Car {

  private static final int DEFAULT_SCORE = 0;
  private int score;

  public Car() {
    this.score = DEFAULT_SCORE;
  }

  public void addScore(int additionalScore) {
    this.score += additionalScore;
  }

  public int getScore() {
    return score;
  }

  public void move() {
    score++;
  }
}
