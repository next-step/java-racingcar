package study.step4.model.car;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import study.step4.model.strategy.MoveStrategy;

public class Cars {

  private static final String CAR_NAME_SPLITER = ",";

  private final List<Car> racingGameCars;

  private Cars(List<Car> cars) {
    this.racingGameCars = cars;
  }

  private static Cars of(List<Car> cars) {
    return new Cars(cars);
  }

  private static Cars of(String[] carNames) {
    return Arrays.stream(carNames)
        .map(Car::new)
        .collect(collectingAndThen(toList(), Cars::of));
  }

  public static Cars of(String carNameStr) {
    return of(carNameStr.split(CAR_NAME_SPLITER));
  }

  public static Cars of(int carNumber) {
    return Stream.generate(Car::new)
        .limit(carNumber)
        .collect(collectingAndThen(toList(), Cars::of));
  }

  public void move(MoveStrategy moveStrategy) {
    for (Car car : racingGameCars) {
      car.move(moveStrategy);
    }
  }

  public int getRacingGameCarsCount() {
    return racingGameCars.size();
  }

  public Car getCar(int carIndex) {
    return racingGameCars.get(carIndex);
  }

  public List<Car> getWinners() {
    Car winnerCarStandard = Collections.max(this.racingGameCars);
    return racingGameCars.stream().filter(car -> car.compareTo(winnerCarStandard) == 0)
        .collect(Collectors.toList());
  }


}
