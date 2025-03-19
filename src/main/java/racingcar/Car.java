package racingcar;

public class Car {
  private final String name;
  private int position;

  public static final int CAR_NAME_MAX_LENGTH = 5;

  public Car(String name) {
    validateName(name);
    this.name = name;
    this.position = 0;
  }

  private void validateName(String name) {
    if (name.length() > CAR_NAME_MAX_LENGTH) {
      throw new IllegalArgumentException("이름은 " + CAR_NAME_MAX_LENGTH + "자 이하여야 합니다.");
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
