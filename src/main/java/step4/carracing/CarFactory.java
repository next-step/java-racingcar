package step4.carracing;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

  public static List<Car> createCars(List<String> carNameList) {
    return carNameList.stream()
                      .map(Car::new)
                      .collect(Collectors.toList());
  }
}
