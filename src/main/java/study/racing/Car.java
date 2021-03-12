package study.racing;

public class Car {

  private int position = 0;

  private static final int MOVE_CONDITION = 4;

  public Car() { }

  public Car(int position) {
    this.position = position;
  }

  public int getPosition() {
    return position;
  }

  public void moveByCondition(int condition) {
    if (condition >= MOVE_CONDITION) {
      move();
    }
  }

  private void move() {
    this.position++;
  }


}
