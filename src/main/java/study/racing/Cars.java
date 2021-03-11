package study.racing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {

  List<Car> cars = new ArrayList<>();

  public Cars() { }

  public Cars(List<Car> cars) {
    this.cars = cars;
  }

  public void add(Car car) {
    this.cars.add(car);
  }

  public void addAll(Car... cars) {
    this.cars.addAll(Arrays.asList(cars));
  }

  public void moveByCondition() {
    for (Car car : cars) {
      int condition = RandomNumberAssigner.getRandomNumber();
      car.moveByCondition(condition);
    }
  }

  public void printPosition() {
    for (Car car : cars) {
      ResultView.printPosition(car.getPosition());
    }
  }

  public int getSize() {
    return cars.size();
  }
}
