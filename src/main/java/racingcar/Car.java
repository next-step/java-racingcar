package racingcar;

public class Car {

  private int position;

  public int getPosition() {
    return position;
  }

  public Car() {
    this.position = 0;
  }

  public void move() {
    this.position++;
  }
}
