package racingCar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingCar.domain.generator.IntGenerator;

public class RacingCars {

  private List<Car> cars;

  public RacingCars(List<Car> cars){
    this.cars = cars;
  }

  public int getCarCount(){
    return cars.size();
  }

  public void move(IntGenerator intGenerator){
    cars.stream().filter(car -> isMovingCar(intGenerator))
        .forEach(Car::move);
  }

  private boolean isMovingCar(IntGenerator intGenerator) {
    int randomNumber = intGenerator.nextInt();
    return randomNumber >= 4;
  }

  @Override
  public String toString(){
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
        .map(Car::getName).collect(Collectors.toList());
  }
}
