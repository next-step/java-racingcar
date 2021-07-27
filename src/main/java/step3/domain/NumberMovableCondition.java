package step3.domain;

public class NumberMovableCondition implements MovableCondition {

  public static final int BOUNDARY = 4;
  public static final int MIN = 0;
  public static final int MAX = 9;

  private final int number;

  public NumberMovableCondition(int number) {
    validate(number);
    this.number = number;
  }

  @Override
  public boolean satisfy() {
    return number >= BOUNDARY;
  }

  private void validate(int randomNumber) {
    if (randomNumber < MIN || randomNumber > MAX) {
      throw new IllegalArgumentException("전진하는 조건은" + MIN + "-" + MAX + " 사이만 가능하다.");
    }
  }
}
