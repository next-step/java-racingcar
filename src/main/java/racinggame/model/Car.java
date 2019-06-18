package racinggame.model;

public class Car {

  private static final int DEFAULT_STATUS = 1;
  private static final int MOVE_VALUE = 4;

  private int status;

  public Car() {
    this.status = DEFAULT_STATUS;
  }

  public int move(int num) {
    if(isMove(num)) {
      status++;
    }
    return status;
  }

  public int getStatus() {
    return status;
  }

  private boolean isMove(int num) {
    return num >= MOVE_VALUE;
  }
}
