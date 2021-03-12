package racing.model;

import racing.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

  List<Car> carList;

  public List<Car> init(int carCount) {
    carList = new ArrayList<>();
    while (carCount-- > 0) carList.add(new Car());

    return carList;
  }

  public List<Car> runCycle() {
    carList.forEach(m -> m.move(RandomGenerator.createRandomValue()));

    return carList;
  }

}
