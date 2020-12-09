package step3.domain;

public class Car {

  public static final int MAX_LENGTH = 5;
  private final String name;
  private int distance = 1;

  public Car(String name) {
    valid(name);
    this.name = name;
  }

  public void move() {
    this.distance++;
  }

  public int getDistance() {
    return this.distance;
  }

  public String getName() {
    return this.name;
  }

  private static void valid(String input) {
    if (input == null || "".equals(input) || input.length() > MAX_LENGTH) {
      throw new IllegalArgumentException();
    }
  }
}
