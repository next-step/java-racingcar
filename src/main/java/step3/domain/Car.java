package step3.domain;

public class Car {

  private static final int STANDARD_FOR_MOVING = 4;
  private static final int INIT_DISTANCE = 1;

  private final Name name;
  private final Distance distance;

  public Car(String name) {
    this.name = new Name(name);
    this.distance = new Distance(INIT_DISTANCE);
  }

  public Car(String name, int distance) {
    this.name = new Name(name);
    this.distance = new Distance(distance);
  }

  public void move(int targetNumber) {
    if (canMove(targetNumber)) {
      this.distance.move();
    }
  }

  public int getDistance() {
    return this.distance.get();
  }

  public String getName() {
    return this.name.get();
  }

  private boolean canMove(int targetNumber) {
    return targetNumber > STANDARD_FOR_MOVING;
  }
}
