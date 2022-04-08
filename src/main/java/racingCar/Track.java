package racingCar;

import java.util.ArrayList;
import java.util.List;

public class Track {



  public List<Car> vehiclesCount(int carCount) {
    List<Car> cars = new ArrayList<>();
    for (int i = 0; i < carCount; i++) {
      cars.add(new Car());
    }
    return cars;
  }
}
