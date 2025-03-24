package racingcar;

public class Car {

  private static final int DEFAULT_SCORE = 0;
  private int score;

  private final String name;

  public Car(String name) {
    this(name, DEFAULT_SCORE);
  }

  public Car(String name, int score) {
    this.name = name;
    this.score = score;
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

  public String showPosition() {
    return "-".repeat(score);
  }

  public String getName() {
    return name;
  }
}
