package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

  private final List<Car> cars;

  public Cars(Names carNames) {
    cars = new ArrayList<>();
    for (int i = 0; i < carNames.size(); i++) {
      cars.add(new Car(carNames.getCarName(i)));
    }
  }

  private static void moveCar(RaceEvaluator raceEvaluator, Car car) {
    if (raceEvaluator.evaluate()) {
      car.move();
    }
  }

  public int size() {
    return cars.size();
  }

  public Car getCar(int index) {
    return cars.get(index);
  }

  public void moveAll(RaceEvaluator raceEvaluator) {
    for (Car car : cars) {
      moveCar(raceEvaluator, car);
    }
  }
}
