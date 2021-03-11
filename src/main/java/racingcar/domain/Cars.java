package racingcar.domain;

import java.util.List;
import racingcar.util.RandomNumberGenerator;

public class Cars {

  private final List<Car> cars;

  public Cars(List<Car> cars) {
    this.cars = cars;
  }

  public List<Car> getCars() {
    return cars;
  }

  public void updateAll(RandomNumberGenerator randomNumberGenerator){
    for(Car car : cars) {
      car.moveCar(randomNumberGenerator.generateRandomNumber());
    }
  }

  public String currentCarsPosition() {
    StringBuilder sb = new StringBuilder();
    for(Car car : cars) {
      sb.append(car.positionToLine()).append("\n");
    }
    return sb.toString();
  }
}
