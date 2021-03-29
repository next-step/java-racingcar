package racingcar;

public class Car {
  private int position;

  public Car() {
    this.position = 0;
  }

  public void moveOne() {
    this.move(1);
  }

  private void move(int distance) {
    this.position += distance;
  }

  public int getPosition() {
    return this.position;
  }
}
