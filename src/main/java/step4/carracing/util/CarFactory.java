package step4.carracing.util;

import step4.carracing.CarMoveStrategy;
import step4.carracing.domain.Car;
import step4.carracing.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
  public static Cars createCars(List<String> carNameList, CarMoveStrategy carMoveStrategy) {
    return carNameList.stream()
            .map(carName -> new Car(carName, carMoveStrategy))
            .collect(Collectors.collectingAndThen(Collectors.toList(), Cars::new));
  }
}
