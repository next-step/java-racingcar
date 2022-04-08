package racingCar;

import java.util.Random;

public class Car {
  private int randomValue;


  public String move() {
    Random random = new Random();
    this.randomValue = random.nextInt(10);
    if(randomValue <=3) {
      return null;
    }
    return "-";
  }

  public void setRandomValue(int randomValue) {

  }

  public int getRandomValue() {
    return randomValue;
  }
}
