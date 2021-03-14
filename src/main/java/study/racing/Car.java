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

  public void move(MoveStrategy strategy) {
    if (strategy.isMove()) {
      this.position ++;
    }
  }

  public void move(MoveStrategy strategy, int number) {
    if (strategy.isMove(number)) {
      this.position ++;
    }
  }

}
