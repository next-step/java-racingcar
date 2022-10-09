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

  public int size() {
    return values.size();
  }

  public void move() {
    for (Car car : values) {
      car.moveIfMovable();
    }
  }
}
