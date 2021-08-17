package step45.domain;

public class Car {

  private final Name name;
  private int location;

  public Car(String name) {
    this.name = new Name(name);
    this.location = 0;
  }

  public void move(int distance) {
    this.location += distance;
  }

  public String getName() {
    return name.getName();
  }

  public int getLocation() {
    return location;
  }
}
