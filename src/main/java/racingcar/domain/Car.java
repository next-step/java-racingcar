package racingcar.domain;

public class Car {
  private int position = 0;

  public static Car createCar() {
    return new Car();
  }

  public int getPosition() {
    return position;
  }

  public void moveCar(int randomNumber) {
    boolean moveable = moveable(randomNumber);
    if(moveable) this.position++;
  }

  private boolean moveable(int randomNumber) {
    return randomNumber >= 4;
  }
}
