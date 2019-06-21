package racinggame.domain;

public class Car {

  private static final int DEFAULT_STATUS = 1;
  private static final int MOVE_VALUE = 4;

  private int status;
  private String name;

  public Car(String name) {
    this.status = DEFAULT_STATUS;
    this.name = name.trim();
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

  public String getName() {
    return name;
  }

  private boolean isMove(int num) {
    return num >= MOVE_VALUE;
  }
}
