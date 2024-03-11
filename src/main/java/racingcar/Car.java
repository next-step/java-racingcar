package racingcar;

public class Car {

  private int position;

  public Car() {
    this.position = 0;
  }

  public void move() {
    this.position++;
  }

  public String getResult() {
    return "-".repeat(this.position);
  }
}
