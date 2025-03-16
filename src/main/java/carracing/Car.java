package carracing;

public class Car {
  private static final int MOVE_THRESHOLD = 4;
  private int currentPosition;

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
