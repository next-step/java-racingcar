package study.step3.factory;

import java.util.ArrayList;
import java.util.List;
import study.step3.domain.Car;

public class CarFactory {

  private CarFactory(){
  }

  public static List<Car> createCars(int numOfCars) {
    List<Car> carList = new ArrayList<>();
    for (int i = 0; i < numOfCars; i++) {
      carList.add(createCar());
    }
    return carList;
  }

  public static Car createCar(){
    return new Car();
  }
}
