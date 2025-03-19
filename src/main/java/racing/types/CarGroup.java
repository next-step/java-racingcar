package racing.types;

import racing.simulator.CarMovingStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarGroup {

  private final List<Car> cars = new ArrayList<>();

  public static CarGroup valueOf(List<CarName> carNames) {
    return new CarGroup(carNames);
  }

  public static CarGroup valueOf(CarCount carCount) {
    return new CarGroup(carCount);
  }

  private CarGroup(List<CarName> carNames) {
    if (hasDuplicateNames(carNames)) {
      throw new IllegalArgumentException("차 이름은 중복될 수 없습니다.");
    }

    for (CarName name : carNames) {
      cars.add(Car.valueOf(name));
    }
  }

  private boolean hasDuplicateNames(List<CarName> carNames) {
    Set<String> uniqueNames = new HashSet<>();
    return carNames.stream()
        .anyMatch(carName -> !uniqueNames.add(carName.getName()));
  }

  private CarGroup(CarCount carCount) {
    for (int i = 0; i < carCount.getCount(); i++) {
      cars.add(new Car());
    }
  }

  public void moveCars(CarMovingStrategy carMovingStrategy) {
    cars.forEach(car -> car.go(carMovingStrategy));
  }

  public List<Car> copyCars() {
    List<Car> res = new ArrayList<>();
    for (Car car : cars) {
      res.add(Car.valueOf(car));
    }
    return res;
  }

  public void resetCars() {
    for (Car car : cars) {
      car.reset();
    }
  }
}
