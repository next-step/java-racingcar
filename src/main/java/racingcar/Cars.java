package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

  private List<Car> cars = new ArrayList<>();

  public Cars(int numberOfCar) {
    makeCars(numberOfCar);
  }

  private void makeCars(int numberOfCar) {
    for (int i = 0; i < numberOfCar; i++) {
      cars.add(i, new Car());
    }
  }

  public void moveCars() {
    cars.stream()
        .forEach(car -> car.move(RandomNumberGenerator.randomValue()));
  }

  public int[] getCarsPosition() {
    int[] carsPosition = new int[cars.size()];
    for (int i = 0; i < cars.size(); i++) {
      carsPosition[i] = cars.get(i).getPosition();
    }
    return carsPosition;
  }
}
