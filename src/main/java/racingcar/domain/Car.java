package racingcar.domain;

public class Car {
  private int position = 0;

  public static Car createCar() {
    return new Car();
  }

  public int getPosition() {
    return position;
  }

  public void moveCar() {
    this.position++;
  }
}
