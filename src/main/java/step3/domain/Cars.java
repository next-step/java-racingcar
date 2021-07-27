package step3.domain;

import static java.util.stream.Collectors.toList;

import java.util.List;

public class Cars {

  private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
  private final List<Car> cars;

  public Cars(List<Name> names) {
    this.cars = create(names);
  }

  public void move() {
    for (Car car : cars) {
      final int randomNumber = randomNumberGenerator.generate();
      car.move(new NumberMovableCondition(randomNumber));
    }
  }

  public int numberOf() {
    return cars.size();
  }

  private List<Car> create(List<Name> names) {
    return names.stream()
        .map(Car::new)
        .collect(toList());
  }

  public List<Car> getCars() {
    return cars;
  }
}
