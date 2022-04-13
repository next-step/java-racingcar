public class Car {

  private static final int INITIAL_POSITION = 0;
  private static final int MINIMUM_DISTANCE_TO_MOVE = 4;

  private int position;

  public Car() {
    this.position = INITIAL_POSITION;
  }

  public void move(int distance) {
    if (distance >= MINIMUM_DISTANCE_TO_MOVE) {
      position += distance;
    }
  }

  public int getPosition() {
    return position;
  }
}
