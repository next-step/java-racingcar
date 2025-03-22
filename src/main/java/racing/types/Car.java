package racing.types;

import racing.simulator.CarMovingStrategy;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Car {

  private final CarName carName;
  private CarLocation carLocation;

  public static String toNameString(List<Car> cars) {
    return cars.stream()
        .map(car -> car.carName.toString())
        .collect(Collectors.joining(", "));
  }

  public static String toLocationString(List<Car> cars) {
    return cars.stream()
        .map(car -> {
          String locationString = car.carLocation.toString();
          return car.carName.equals(new CarName())
              ? locationString
              : car.carName + ":" +locationString;
        })
        .collect(Collectors.joining("\n", "", "\n"));
  }

  public Car() {
    this(new CarName());
  }

  public static Car valueOf(CarName carName) {
    return new Car(carName, new CarLocation());
  }

  private Car(CarName carName) {
    this(carName, new CarLocation());
  }

  public static Car valueOf(Car car) {
    return new Car(car);
  }

  private Car(Car car) {
    this(car.carName, car.carLocation);
  }

  public static Car valueOf(CarLocation carLocation) {
    return new Car(carLocation);
  }

  private Car(CarLocation carLocation) {
    this(new CarName(), carLocation);
  }

  public static Car valueOf(CarName carName, CarLocation carLocation) {
    return new Car(carName, carLocation);
  }

  private Car(CarName carName, CarLocation carLocation) {
    this.carName = carName;
    this.carLocation = carLocation;
  }

  public Car toMovingCar(CarMovingStrategy carMovingStrategy) {
    if (carMovingStrategy.canMove()) {
      return new Car(CarName.valueOf(this.carName), carLocation.getNextLocation());
    }

    return new Car(CarName.valueOf(this.carName), new CarLocation(carLocation));
  }

  public boolean isBehind(Car car) {
    return this.carLocation.compareTo(car.carLocation) < 0;
  }

  public boolean isSameLocation(Car car) {
    return this.carLocation.compareTo(car.carLocation) == 0;
  }

  public boolean isSameName(Car car) {
    return this.carName.equals(car.carName);
  }

  public boolean hasDefaultName() {
    return this.carName.equals(new CarName());
  }

  public void reset() {
    carLocation = new CarLocation();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Car car = (Car) o;
    return Objects.equals(carName, car.carName) && Objects.equals(carLocation, car.carLocation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(carName, carLocation);
  }
}
