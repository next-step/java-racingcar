package racing.simulator;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGameSimulator {

  private final List<Car> cars = new ArrayList<>();

  public CarRacingGameSimulator(int carCount, CarMovingStrategy carMovingStrategy) {
    for (int i = 0; i < carCount; i++) {
      cars.add(new Car(carMovingStrategy));
    }
  }

  public List<List<Car>> run(int simulateCount) {
    List<List<Car>> res = new ArrayList<>();
    for (int i = 0; i < simulateCount; i++) {
      moveCars();
      res.add(copyCars());
    }
    resetCars();
    return res;
  }

  public void moveCars() {
    cars.forEach(Car::go);
  }

  public List<Car> copyCars() {
    List<Car> res = new ArrayList<>();
    for (Car car: cars) {
      res.add(new Car(car));
    }
    return res;
  }

  public void resetCars() {
    for (Car car : cars) {
      car.reset();
    }
  }
}
