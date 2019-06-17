package racingcar;

public class Cars {

  private Car[] cars;

  public Cars(int numberOfCar) {
    cars = new Car[numberOfCar];
    carMake();
  }

  private void carMake() {
    for (int i = 0; i < cars.length; i++) {
      cars[i] = new Car();
    }
  }

  public int[] move() {
    int[] moveDistance = new int[cars.length];
    for (int i = 0; i < cars.length; i++) {
      moveDistance[i] = cars[i].move(RandomNumberGenerator.randomValue());
    }
    return moveDistance;
  }

  public int[] getCarsPosition() {
    int[] carsPosition = new int[cars.length];
    for (int i = 0; i < cars.length; i++) {
      carsPosition[i] = cars[i].getPosition();
    }
    return carsPosition;
  }
}
