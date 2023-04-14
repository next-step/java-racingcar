package racing.race;

import java.util.LinkedList;
import java.util.List;

public class Cars {

  private List<Car> cars = new LinkedList<>();

  public void ready(int carsNumber) {
    if (carsNumber < 0) {
      throw new NumberFormatException();
    }
    for (int i = 0; i < carsNumber; i++) {
      cars.add(new Car());
    }
  }

  public List<Car> getGameCar() {
    return cars;
  }
}
