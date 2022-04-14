package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

  private final List<Car> cars;

  public Cars(List<Car> cars) {
    this.cars = cars;
  }

  public void attempt() {
    for (Car car : cars) {
      car.attempt();
    }
  }

  public List<Integer> getDistances() {
    List<Integer> distances = new ArrayList<>();
    for (Car c : cars) {
      distances.add(c.getDistance());
    }
    return distances;
  }

}
