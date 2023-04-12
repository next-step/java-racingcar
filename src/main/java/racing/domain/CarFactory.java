package racing.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 자동차 생성 공장 (CarFactory) - 책임 - 지정된 수의 Car 객체를 생성한다.
 */
public class CarFactory {

  public List<Car> createCars(int numberOfCars) {
    return IntStream.range(0, numberOfCars)
        .mapToObj(i -> new Car())
        .collect(Collectors.toList());
  }

}
