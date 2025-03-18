package racing;

public class Car {

  private static final int MOVE_THRESHOLD = 4;

  private int position;

  public int getPosition() {
    return position;
  }

  public void driveOrStop(int randomNumber) {
    if (randomNumber >= MOVE_THRESHOLD) {
      position++;
    }
  }


}
