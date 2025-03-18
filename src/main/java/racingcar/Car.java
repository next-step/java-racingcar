package racingcar;

public class Car {
  private final String name;
  private int position;

  public Car(String name) {
    this.name = name;
    this.position = 0;
  }

  public void move() {
    position++;
  }

  public int getPosition() {
    return position;
  }

  public String getName() {
    return name;
  }
}
