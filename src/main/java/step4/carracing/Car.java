package step4.carracing;

public class Car {
  static final int MOVE_THRESHOLD = 4;
  private static final int INIT_POSITION = 1;
  private int position;

  public Car() {
    this.position = INIT_POSITION;
  }

  public void move(int number) {
    if (isMovable(number)) {
      position++;
    }
  }

  private boolean isMovable(int number) {
    return number >= MOVE_THRESHOLD;
  }

  public int getPosition() {
    return position;
  }
}
