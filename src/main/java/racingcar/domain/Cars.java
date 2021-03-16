package racingcar.domain;

import static racingcar.domain.Car.DEFAULT_DISTANCE;

import java.util.ArrayList;
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
    List<String> winners = new ArrayList<>();

    for (Car car : cars) {
      addWinnerName(winners, car);
    }

    return Winner.of(winners);
  }

  private void addWinnerName(List<String> winners, Car car) {
    if (car.isWinner(getMaxDistance())) {
      winners.add(car.getName());
    }
  }

  private int getMaxDistance() {
    int maxDistance = DEFAULT_DISTANCE;

    for (Car car : cars) {
      int distance = car.getDistance();
      maxDistance = Math.max(maxDistance, distance);
    }

    return maxDistance;
  }
}
