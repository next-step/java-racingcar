package racing.types;

import racing.simulator.RacingCarMovingStrategy;

import java.util.ArrayList;
import java.util.List;

public class CarGroup {

  private final List<Car> cars = new ArrayList<>();

  public CarGroup(List<CarName> carNames) {
    for (CarName name : carNames) {
      cars.add(new Car(name));
    }
  }

  public CarGroup(CarCount carCount) {
    for (int i = 0; i < carCount.getCount(); i++) {
      cars.add(new Car());
    }
  }

  public void moveCars(RacingCarMovingStrategy racingCarMovingStrategy) {
    cars.forEach(car -> car.go(racingCarMovingStrategy));
  }

  public List<Car> copyCars() {
    List<Car> res = new ArrayList<>();
    for (Car car : cars) {
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
