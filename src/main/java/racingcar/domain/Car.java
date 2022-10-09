package racingcar.domain;

public class Car {

  private int carPosition = 0;
  private final String name;

  public Car(String name) {
    validateCar(name);
    this.name = name;
    this.carPosition = 0;
  }

  private void validateCar(String name) {
    if (name.length() > 5) {
      throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다");
    }
  }

  public void move() {
    carPosition++;
  }

  public String getName() {
    return name;
  }

  public int getCarPosition() {
    return carPosition;
  }

}
