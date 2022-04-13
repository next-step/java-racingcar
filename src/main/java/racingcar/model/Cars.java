package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

  private List<Car> cars;

  public Cars(List<Car> cars) {
    this.cars = cars;
  }

  public Cars(int count) {
    cars = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      cars.add(new Car());
    }
  }

  public List<Car> getCars() {
    return cars;
  }

  public void move(List<Integer> randomNumbers) {
    for (int i = 0; i < randomNumbers.size(); i++) {
      getCars().get(i).moveOrStop(randomNumbers.get(i));
    }
  }

  public List<Integer> getPositions() {
    return cars.stream()
        .map(Car::getPosition)
        .collect(Collectors.toList());
  }
}
