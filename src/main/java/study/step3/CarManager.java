package study.step3;

import java.util.Random;

public class CarManager {

  static final private Random RANDOM_INSTANCE = new Random();
  static final private int DEFAULT_BOUND = 10;

  private CarManager() {
  }

  public static Car[] createCars(int numOfCars) {
    Car[] cars = new Car[numOfCars];
    for (int i = 0; i < numOfCars; i++) {
      cars[i] = new Car();
    }
    return cars;
  }

  public static void moveCars(Car[] cars) {
    for (Car car : cars) {
      car.move(generateRandomInt());
    }
  }

  private static int generateRandomInt() {
    return RANDOM_INSTANCE.nextInt(DEFAULT_BOUND);
  }
}
