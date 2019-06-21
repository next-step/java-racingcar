package racinggame.domain;

public class Car {

  private static final int DEFAULT_STATUS = 1;
  private static final int MOVE_VALUE = 4;

  private int position;
  private String name;

  public Car(String name) {
    this(name, DEFAULT_STATUS);
  }

  public Car(String name, int position) {
    this.name = name;
    this.position = position;
  }

  public int move(int num) {
    if(isMove(num)) {
      position++;
    }
    return position;
  }

  public int getStatus() {
    return position;
  }

  public String getName() {
    return name;
  }

  private boolean isMove(int num) {
    return num >= MOVE_VALUE;
  }
}
