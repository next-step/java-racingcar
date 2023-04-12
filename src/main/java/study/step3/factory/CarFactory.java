package study.step3.factory;

import java.util.ArrayList;
import java.util.List;
import study.step3.domain.Car;

public class CarFactory {

  public List<Car> createCars(int numOfCars) {
    List<Car> carList = new ArrayList<>();
    for (int i = 0; i < numOfCars; i++) {
      carList.add(new Car());
    }
    return carList;
  }
}
