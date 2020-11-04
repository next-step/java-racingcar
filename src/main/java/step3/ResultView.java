package step3;

import java.util.Set;

public class ResultView {
  public void resultPrint(Set<Car> cars) {
    cars.stream().map(Car::toString).forEach(System.out::println);
    System.out.println();
  }
}
