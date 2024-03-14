package racingcar.step4.domain;

public class Position {

  public static final int DEFAULT_START_POSITION = 0;
  private int position;

  private Position(int position) {
    this.position = position;
  }

  public static Position defaultPosition() {
    return new Position(DEFAULT_START_POSITION);
  }

  public static Position specificPosition(int position) {
    return new Position(position);
  }

  public void forward() {
    this.position += 1;
  }

  public int get() {
    return position;
  }
}
