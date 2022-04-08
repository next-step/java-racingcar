package racingCar;

import java.util.Random;

public class Car {

  private int randomValue;

  public String move() {
    setRandomValue();
    if (randomValue <= 3) {
      return null;
    }
    return "-";
  }

  public void setRandomValue() {
    Random random = new Random();
    this.randomValue = random.nextInt(10);
  }

  public int getRandomValue() {
    return randomValue;
  }
}
