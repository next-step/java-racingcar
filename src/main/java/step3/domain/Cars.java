package step3.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
  private final List<Car> carList;

  public Cars(int number) {
    this.carList = Stream.generate(Car::new)
        .limit(number)
        .collect(Collectors.toList());
  }

  public void race() {
    carList.forEach(car -> {
      if (RacingRule.possibleToMove()) {
        car.move();
      }
    });
  }

  public List<Car> getCars() {
    return Collections.unmodifiableList(this.carList);
  }
}
