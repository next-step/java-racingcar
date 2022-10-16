package racing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racing.MovingStrategy.RandomMovingStrategy;

public class Cars {

  private final List<Car> values = new ArrayList<>();

  public Cars(int numberOfCar) {
    for (int i = 0; i < numberOfCar; i++) {
      Car car = new Car();
      car.setMovingStrategy(new RandomMovingStrategy());
      values.add(car);
    }
  }

  public void move() {
    for (Car car : values) {
      car.moveIfMovable();
    }
  }

  public List<Integer> getLocations() {
    List<Integer> locations = new ArrayList<>();
    for (Car car : values) {
      locations.add(car.nowLocation());
    }
    return Collections.unmodifiableList(locations);
  }
}
