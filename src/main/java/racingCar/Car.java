package racingCar;

import java.util.Random;

public class Car {

  private final String name;
  private int position;
  private final IntGenerator intGenerator;

  public Car(String name, IntGenerator intGenerator) {
    this.name = name;
    this.position = 0;
    this.intGenerator = intGenerator;
  }

  public String getName() {
    return name;
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
