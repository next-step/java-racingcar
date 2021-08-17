package step45.domain;

public class Car {

  private final Name name;
  private Location location;

  public Car(String name) {
    this.name = new Name(name);
    this.location = new Location(0);
  }

  public void move(int distance) {
    this.location = this.location.increase(distance);
  }

  public String getName() {
    return name.getName();
  }

  public int getLocation() {
    return location.getLocation();
  }
}
