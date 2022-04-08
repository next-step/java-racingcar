package racingCar;

import java.util.ArrayList;
import java.util.List;

public class Track {

  private final List<Car> cars = new ArrayList<>();;

  public void addCar(int carCount) {
    for (int i = 0; i < carCount; i++) {
      cars.add(new Car());
    }
  }

  public void play(int count) {

  }


  public List<Car> getCars() {
    return cars;
  }
}
