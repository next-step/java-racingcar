package racingCar.domain;


public class Car {

  private final String name;
  private int position;

  public Car(String name) {
    verifyCarName(name);
    this.name = name;
    this.position = 0;
  }

  public String getName() {
    return name;
  }

  public int getPosition() {
    return position;
  }

  public String getMovedPath() {
    return "-".repeat(position);
  }

  public void move() {
    position++;
  }

  private void verifyCarName(String carName) {
    int maxCarNameLength = 5;
    if (carName != null && carName.length() > maxCarNameLength) {
      throw new RuntimeException(String.format("차의 이름은 %d자를 초과할 수 없습니다.", maxCarNameLength));
    }
  }
}
