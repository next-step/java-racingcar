package step4.carracing;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

  public static Car createCar(String carName) {
    return Car.of(carName);
  }

  public static List<Car> createCars(List<String> carNameList) {
    return carNameList.stream()
                      .map(Car::of)
                      .collect(Collectors.toList());
  }
}
