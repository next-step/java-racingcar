package racing;

public class Car {

  public static final int START_LOCATION = 1;
  public static final int DISTANCE_TO_MOVE_AT_ONCE = 1;

  private int location;

  private MovingStrategy movingStrategy;

  public Car() {
    this.location = START_LOCATION;
  }

  public int nowLocation() {
    return location;
  }

  public void moveIfMovable(){
    if (this.isMovable()) {
      this.move();
    }
  }

  public void move() {
    this.location += DISTANCE_TO_MOVE_AT_ONCE;
  }

  public void setMovingStrategy(MovingStrategy movingStrategy) {
    this.movingStrategy = movingStrategy;
  }

  private boolean isMovable() {
    return movingStrategy.isMovable();
  }
}
