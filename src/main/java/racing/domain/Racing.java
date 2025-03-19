package racing.domain;

import java.util.ArrayList;
import java.util.List;
import racing.RandomGenerator;

public class Racing {

  List<Car> cars = new ArrayList<>();

  public Racing(int carCount) {
    generateCars(carCount);
  }

  private List<Car> generateCars(int carCount) {
    for (int i = 0; i < carCount; i++) {
      cars.add(new Car());
    }

    return cars;
  }

  public List<Car> getCars() {
    return cars;
  }

  public void simulateRace() {
    for (Car car : cars) {
      car.driveOrStop(RandomGenerator.generate());
    }
  }
}
