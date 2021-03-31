package study.step3;

public class Car {

  private int position;

  public Car() {};

  public Car(int position) {
    this.position = position;
  }

  public int curPosition() {
    return position;
  }

  public void move(int position) {
    this.position = position;
  }

}
