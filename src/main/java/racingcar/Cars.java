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

  public int size() {
    return cars.size();
  }

  public Car getCar(int index) {
    return cars.get(index);
  }

  public void move(RaceEvaluator raceEvaluator) {
    for (Car car : cars) {
      if (raceEvaluator.evaluate()) {
        car.move();
      }
    }
  }
}
