package racingCar.game;

import java.util.List;

public class RacingCars {

  List<Car> cars;

  public RacingCars(List<Car> cars){
    this.cars = cars;
  }

  public void move(){
    for(Car car : cars){
      car.move();
    }
  }

  public String getMovedPath(){
    StringBuilder sb = new StringBuilder();
    for (Car car : cars) {
      sb.append(String.format("%s : %s\n", car.getName(), car.getMovedPath()));
    }
    return sb.toString();
  }

  public List<String> findWinners() {
    int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
    return cars.stream()
        .filter(car -> car.getPosition() == maxPosition)
        .map(Car::getName).collect(java.util.stream.Collectors.toList());
  }
}
