package racingCar;

public class Car {
  private int randomValue;

  public String move() {
    if(randomValue <=3) {
      return null;
    }
    return "-";
  }

  public void setRandomValue(int randomValue) {
    this.randomValue = randomValue;
  }

  public int getRandomValue() {
    return randomValue;
  }
}
