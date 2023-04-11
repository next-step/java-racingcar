package study.step3;

public class Car {

  static final private int MINIMUM_MOVE_VALUE = 4;
  static final private String DEFAULT_FOOTPRINT = "";
  static final private String FORWARD_FOOTPRINT = "-";

  private int carNum;
  private String footPrint;

  public Car(int carNum) {
    this.carNum = carNum;
    this.footPrint = DEFAULT_FOOTPRINT;
  }

  public void move(int moveValue) {
    if (isMoving(moveValue)) {
      addFootPrint();
    }
  }

  private boolean isMoving(int moveValue) {
    return moveValue >= MINIMUM_MOVE_VALUE;
  }

  private void addFootPrint() {
    footPrint += FORWARD_FOOTPRINT;
  }

  @Override
  public String toString() {
    return "Car" + carNum + " " + footPrint;
  }
}
