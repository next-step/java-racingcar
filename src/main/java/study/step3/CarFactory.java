package study.step3;

public class CarFactory {

  private CarFactory() {
  }

  public static Car[] createCars(int numOfCars) {
    Car[] cars = new Car[numOfCars];
    for (int i = 0; i < numOfCars; i++) {
      cars[i] = new Car(i + 1);
    }
    return cars;
  }
}
