package racingrefactoring.domain;

public class MaxPosition {

  private final int maxPosition;

  public MaxPosition(int maxPosition) {
    this.maxPosition = maxPosition;
  }

  public boolean isSame(int position) {
    return maxPosition == position;
  }
}
