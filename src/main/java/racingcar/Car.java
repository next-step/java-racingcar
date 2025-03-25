package racingcar;

public class Car {

  private static final int DEFAULT_SCORE = 0;
  private final String name;
  private int score;

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

  public void tryMove(RaceEvaluator raceEvaluator) {
    if (raceEvaluator.evaluate()) {
      score++;
    }
  }

  public String showPosition(String marker) {
    return marker.repeat(score);
  }

  public String getName() {
    return this.name;
  }

  public boolean isWinner(int winnerScore) {
    return winnerScore == this.score;
  }

  public boolean hasHigherScore(int comparisonScore) {
    return this.score > comparisonScore;
  }
}
