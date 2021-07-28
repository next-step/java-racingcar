package step3.domain;

public class Car {

  public static final int INITIAL_LOCATION = 0;

  private final Name name;
  private int location = INITIAL_LOCATION;

  public Car(Name name) {
    this.name = name;
  }

  public Car(Name name, int location) {
    this.name = name;
    this.location = location;
  }

  public Car(String name, int location) {
    this.name = new Name(name);
    this.location = location;
  }

  public void move(MovableCondition movableCondition) {
    if (movableCondition.satisfy()) {
      location++;
    }
  }

  public int getLocation() {
    return location;
  }

  public String getName() {
    return name.getName();
  }
}
