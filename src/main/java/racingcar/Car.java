package racingcar;

public class Car {
  private final String name;
  private int position;

  public Car(String name) {
    validateName(name);
    this.name = name;
    this.position = 0;
  }

  private void validateName(String name) {
    if (name.length() > 5) {
      throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
    }
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
