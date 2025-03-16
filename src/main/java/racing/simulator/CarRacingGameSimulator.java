package racing.simulator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingGameSimulator {

  private final List<Car> cars = new ArrayList<>();

  public CarRacingGameSimulator(int carCount, CarMovingStrategy carMovingStrategy) {
    for (int i = 0; i < carCount; i++) {
      cars.add(new Car(carMovingStrategy));
    }
  }

  public List<List<Integer>> run(int simulateCount) {
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < simulateCount; i++) {
      moveCars();
      res.add(getCarsLocation());
    }
    resetCars();
    return res;
  }

  public List<Integer> getCarsLocation() {
    return cars.stream().map(Car::getLocation).collect(Collectors.toList());
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
