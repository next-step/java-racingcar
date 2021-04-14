package study.step3.domain;

public class Car {

  private static final int MOVE_CONDITION_NUM = 4;

  private int position;

  public Car() { }

  public Car(int position) {
    this.position = position;
  }

  public int curPosition() {
    return position;
  }

  public void move(int conditionNumber) {
    if (isMovable(conditionNumber)) {
      this.position +=  + 1;
    }
  }

  public boolean isMovable(int conditionNumber) {
    return conditionNumber >= MOVE_CONDITION_NUM;
  }

}
