package racingcar;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {

  public static final int BOUND = 10;

  private final Random random;
  private List<Car> cars;

  public Cars(Random random) {
    this.random = random;
  }

  public void initialize(List<Car> cars) {
    this.cars = Collections.unmodifiableList(cars);
  }

  public int getCarCount() {
    return cars.size();
  }

  public void moveAll() {
    cars.forEach(car -> car.move(random.nextInt(BOUND)));
  }

  public String getNameAndStatus() {
    return cars.stream()
        .map(car -> car.getName() + " : " + car.showStatus())
        .collect(Collectors.joining(System.lineSeparator()));
  }

  public Winner getWinner() {
    final int maxDistance = getMaxDistance();

    return Winner.of(cars.stream()
        .filter(car -> car.isWinner(maxDistance))
        .map(Car::getName)
        .collect(Collectors.toList()));
  }

  private int getMaxDistance() {
    return cars.stream().mapToInt(Car::getDistance).max().orElse(0);
  }
}
