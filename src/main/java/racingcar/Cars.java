package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

  private List<Car> cars = new ArrayList<>();

  public Cars(String[] carNames) {
    makeCars(carNames);
  }

  private void makeCars(String[] carNames) {
    for (int i = 0; i < carNames.length; i++) {
      cars.add(i, new Car(carNames[i]));
    }
  }

  public List<Car> moveCars() {
    cars.stream()
        .forEach(car -> car.move(RandomNumberGenerator.randomValue()));
    return cars;
  }

}
