package study.step3.factory;

import java.util.ArrayList;
import java.util.List;
import study.step3.domain.Car;

public class CarFactory {

  private CarFactory(){
  }

  public static List<Car> createCars(String[] nameOfCars) {
    List<Car> cars = new ArrayList<>();
    for (int i = 0; i < nameOfCars.length; i++) {
      cars.add(createCar(nameOfCars[i]));
    }
    return cars;
  }

  public static Car createCar(String name){
    return new Car(name);
  }
}
