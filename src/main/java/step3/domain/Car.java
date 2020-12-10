package step3.domain;

public class Car {

  private static final int STANDARD_FOR_MOVING = 4;
  private static final int MAX_LENGTH = 5;

  private final String name;
  private int distance = 1;

  public Car(String name) {
    valid(name);
    this.name = name;
  }

  public void move(int targetNumber) {
    if (canMove(targetNumber)) {
      this.distance++;
    }
  }

  public int getDistance() {
    return this.distance;
  }

  public String getName() {
    return this.name;
  }

  private boolean canMove(int targetNumber) {
    return targetNumber > STANDARD_FOR_MOVING;
  }

  private static void valid(String input) {
    if (input == null || "".equals(input) || input.length() > MAX_LENGTH) {
      throw new IllegalArgumentException();
    }
  }
}
