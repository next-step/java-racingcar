package study.step3;

public class Car {

  static final private int MINIMUM_MOVE_VALUE = 4;

  private int carNumber;
  private String footPrint;

  public Car(int carNumber) {
    this.carNumber = carNumber;
    this.footPrint = "";
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
    footPrint += "-";
  }

  @Override
  public String toString() {
    return "Car" + carNumber + " " + footPrint;
  }
}
