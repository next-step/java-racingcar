package racing;

public class Car {

  public static final int START_LOCATION = 1;
  public static final int DISTANCE_TO_MOVE_AT_ONCE = 1;

  private String name;

  private int location = START_LOCATION;

  private MovingStrategy movingStrategy;

  public Car(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getLocation() {
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
