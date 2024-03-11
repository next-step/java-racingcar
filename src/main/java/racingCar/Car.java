package racingCar;

import java.util.Random;

public class Car {

  private int position;
  private final IntGenerator intGenerator;

  public Car(IntGenerator intGenerator) {
    this.position = 0;
    this.intGenerator = intGenerator;
  }

  public int getPosition() {
    return position;
  }

  public String getMovedPath() {
    return "-".repeat(position);
  }

  public void move() {
    int randomNumber = intGenerator.nextInt(10);
    if (randomNumber >= 4) {
      position++;
    }
  }

}
