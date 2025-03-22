package racing.types;

import racing.simulator.CarMovingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CarGroup {

  private final List<Car> cars;

  public CarGroup() {
    cars = new ArrayList<>();
  }

  public static CarGroup valueOf(int size) {
    return new CarGroup(size);
  }

  private CarGroup(int size) {
    cars = new ArrayList<>();

    for (int i = 0; i < size; i++) {
      cars.add(new Car());
    }
  }

  public static CarGroup valueOf(List<Car> cars) {
    return new CarGroup(cars);
  }

  private CarGroup(List<Car> cars) {
    this.cars = new ArrayList<>();
    cars.forEach(this::add);
  }

  public void add(Car newCar) {
    cars.add(newCar);
  }

  public CarGroup toTryMoveCarGroup(CarMovingStrategy carMovingStrategy) {
    List<Car> movingCars = cars.stream()
        .map(car -> car.toMovingCar(carMovingStrategy))
        .collect(Collectors.toList());

    return CarGroup.valueOf(movingCars);
  }

  public void resetCars() {
    for (Car car : cars) {
      car.reset();
    }
  }

  public CarGroup toWinnerCarGroup() {
    Car maxLocationCar = cars.stream()
        .reduce((car1, car2) -> car1.isBehind(car2) ? car2 : car1)
        .orElse(null);

    return CarGroup.valueOf(cars.stream()
        .filter(car -> car.isSameLocation(maxLocationCar))
        .collect(Collectors.toList()));
  }

  public String toNameString() {
    return Car.toNameString(this.cars);
  }

  public String toLocationString() {
    return Car.toLocationString(this.cars);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CarGroup carGroup = (CarGroup) o;
    return Objects.equals(cars, carGroup.cars);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(cars);
  }
}
