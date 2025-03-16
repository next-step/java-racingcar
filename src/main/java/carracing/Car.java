package carracing;

public class Car {
  private static final int INITIAL_POSITION = 1;
  private static final int MOVE_THRESHOLD = 4;
  private int currentPosition;

  public Car() {
    currentPosition = INITIAL_POSITION;
  }

  public int getPosition() {
    return currentPosition;
  }

  public void move(int number) {
    if (shouldMove(number)) {
      currentPosition++;
    }
  }

  private boolean shouldMove(int number) {
    return number >= MOVE_THRESHOLD;
  }
}
