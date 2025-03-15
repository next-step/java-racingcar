package racing.simulator;

public class CarRacingGameSimulator {

  private final int carCount;
  private final CarMoveDecider carMoveDecider;
  private final Car[] cars;

  public CarRacingGameSimulator(int carCount, CarMoveDecider carMoveDecider) {
    this.carCount = carCount;
    this.carMoveDecider = carMoveDecider;
    this.cars = new Car[carCount];
    for (int i = 0; i < carCount; i++) {
      cars[i] = new Car();
    }
  }

  public void tryMoveCars() {
    for (Car car : cars) {
      tryMoveCar(car);
    }
  }

  void tryMoveCar(Car car) {
    if (this.carMoveDecider.canMove()) {
      car.go();
    }
  }

  public Car[] copyCars() {
    Car[] res = new Car[carCount];
    for (int i = 0; i < carCount; i++) {
      res[i] = new Car(cars[i]);
    }
    return res;
  }

  public void resetCars() {
    for (Car car : cars) {
      car.reset();
    }
  }
}
