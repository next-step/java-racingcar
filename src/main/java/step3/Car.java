package step3;

public class Car {

  private int score;

  public Car() {
    this.score = 0;
  }

  public void mergeScore(int previousScore) {
    this.score += previousScore;
  }

  public int getScore() {
    return score;
  }

  public void move() {
    score++;
  }
}
