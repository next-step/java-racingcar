package racing.domain;

import java.util.ArrayList;
import java.util.List;
import racing.domain.strategy.MoveStrategy;

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

  public static Cars newInstance(int carCount, MoveStrategy moveStrategy) {
    List<Car> carList = new ArrayList<>();
    for (int i = 0; i < carCount; i++) {
      carList.add(new Car(moveStrategy));
    }
    return new Cars(carList);
  }

}
