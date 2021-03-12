package racing.model;

import racing.model.Car;
import racing.model.RandomCar;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

  public List<Car> makeAndReturnCar(int carCount){
    List<Car> carList = new ArrayList<>();
    while(carCount-->0){
      carList.add(new RandomCar());
    }
    return carList;
  }
}
