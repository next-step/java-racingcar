package racingcar;

public class CarName {
  private String name;
  private static final int LENGTH_LIMIT = 5;

  public CarName(String name) {
    if (isValid(name)) {
      this.name = name;
    }
  }

  private boolean isValid(String name) {
    if (name.length() > LENGTH_LIMIT) {
      System.out.println("car name: " + name);
      throw new IllegalArgumentException("Car name longer than 5 not allowed.");
    }
    return true;
  }

  @Override
  public String toString() {
    return this.name;
  }
}