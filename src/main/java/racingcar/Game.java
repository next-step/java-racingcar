package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

  private List<Car> cars;

  public void initializeCars(int size) {
    List<Car> newCars = new ArrayList<>();

    for (int i = 0; i < size; i++) {
      newCars.add(new Car());
    }

    this.cars = Collections.unmodifiableList(newCars);
  }

  public int getCarSize() {
    return cars.size();
  }
}
