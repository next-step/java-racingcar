package step4;

public class Car {

  private final String name;
  private int location;

  public Car(String name) {
    checkNameLength(name);
    this.name = name;
    location = 0;
  }

  public void move() {
    location++;
  }

  public String getName() {
    return name;
  }

  public int getLocation() {
    return location;
  }

  private void checkNameLength(String name) {
    if (name.length() > 5) {
      throw new IllegalArgumentException("자동차의 이름은 5자를 초과할 수 없습니다.");
    }
  }
}
