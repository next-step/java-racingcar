package racingcar;

public class Position {

  private static final int DEFAULT_POSITION = 0;
  private int value;

  public Position(int value) {
    this.value = value;
  }

  public Position() {
    this(DEFAULT_POSITION);
  }

  public void move() {
    this.value++;
  }

  public void add(int additionalScore) {
    this.value += additionalScore;
  }

  public boolean isSameAs(int comparisonScore) {
    return this.value == comparisonScore;
  }

  public String showPosition(String marker) {
    return marker.repeat(value);
  }

  public int getValue() {
    return value;
  }
} 