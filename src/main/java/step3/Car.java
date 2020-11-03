package step3;

public class Car {
  private int car;
  private int move;

  public void setMove() {
    this.move++;
    System.out.print("-");
  }

  public Car(int car) {
    this.car = car;
  }
}
