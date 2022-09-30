package racingcar.domain;

import java.util.List;

public class CarFacility {

  public List<Car> buildCar(int carNum) {

    List<Car> cars = new Cars().cars;
    for (int i = 0; i < carNum; i++) {
      cars.add(new Car());
    }
    return cars;
  }


}
