package step3;

import java.util.ArrayList;
import java.util.List;

public class Cars {

  private final List<Car> cars;

  public Cars(int carCount) {
    cars = new ArrayList<>(carCount);
    for (int i = 0; i < carCount; i++) {
      cars.add(new Car());
    }
  }

  public int size() {
    return cars.size();
  }

  public Car getCar(int index) {
    return cars.get(index);
  }

}
