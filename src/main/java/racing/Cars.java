package racing;

import java.util.ArrayList;
import java.util.List;

public class Cars {

  private final List<Car> values = new ArrayList<>();

  public Cars(int numberOfCar) {
    for (int i = 0; i < numberOfCar; i++) {
      values.add(new Car());
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
    return locations;
  }
}
