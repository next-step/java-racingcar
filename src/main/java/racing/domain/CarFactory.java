package racing.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 자동차 생성 공장 (CarFactory) - 책임 - 지정된 수의 Car 객체를 생성한다.
 */
public class CarFactory {

  private CarFactory() {
  }

  public static List<Car> createCars(String carsName) {
    String[] names = splitCarsName(carsName);
    return IntStream.range(0, names.length)
        .mapToObj(i -> new Car(names[i]))
        .collect(Collectors.toList());
  }

  private static String[] splitCarsName(String carsName) {
    return carsName.split(",");
  }

}
