package racingCar;

public class RacingCar {

  private int moveCount;

  public RacingCar() {
    this.moveCount = 0;
  }

  public void move() {
    this.moveCount++;
  }

  public void print() {
    StringBuffer stringBuffer = new StringBuffer();

    for (int i = 0; i < moveCount; i++) {
      stringBuffer.append("-");
    }

    System.out.println(stringBuffer);
  }
}
