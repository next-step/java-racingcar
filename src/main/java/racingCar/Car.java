package racingCar;

import java.util.Random;

public class Car {

  private int position;
  private final Random random;

  public Car() {
    this.position = 0;
    this.random = new Random();
  }

  public int getPosition() {
    return position;
  }

  public String getMovedPath() {
    return "-".repeat(position);
  }

  public void move() {
    int randomNumber = random.nextInt(10);
    if (randomNumber >= 4) {
      position++;
    }
  }

}
