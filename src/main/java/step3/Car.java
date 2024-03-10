package step3;

public class Car {
  private int location = 0;
  private CarName name = new CarName("");

  public Car() {
  }

  public Car(String name) {
    this.name = new CarName(name);
  }

  public Car(String name, int location) {
    this.name = new CarName(name);
    this.location = location;
  }

  public Car(int location) {
    this.location = location;
  }
  public void moveConditionally(final int condition) {
    if (meetMoveCondition(condition)) {
      this.location++;
    }
  }

  private boolean meetMoveCondition(final int condition) {
    final int CRITERIA = 4;
    return condition >= CRITERIA;
  }

  public boolean isLocationValueOf(final int location) {
    return this.location == location;
  }

  public String trace(final String distanceUnit) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < this.location; i++) {
      sb.append(distanceUnit);
    }

    return sb.toString();
  }

  public String name() {
    return this.name.toString();
  }

  static class CarName {
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
}
