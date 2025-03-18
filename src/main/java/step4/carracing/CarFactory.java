package step4.carracing;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

  static Car createCar(String carName, CarMoveStrategy carMoveStrategy) {
    return Car.of(carName, carMoveStrategy);
  }

  public static List<Car> createCars(List<String> carNameList, CarMoveStrategy carMoveStrategy) {
    return carNameList.stream()
                      .map(carName -> createCar(carName, carMoveStrategy))
                      .collect(Collectors.toList());
  }
}
