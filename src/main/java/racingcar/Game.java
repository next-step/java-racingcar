package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Game {

  public static final int BOUND = 10;

  private final Random random;
  private List<Car> cars;

  public Game(Random random) {
    this.random = random;
  }

  public void initializeCars(int size) {
    List<Car> newCars = new ArrayList<>();

    for (int i = 0; i < size; i++) {
      newCars.add(new Car());
    }

    this.cars = Collections.unmodifiableList(newCars);
  }

  public int getCarSize() {
    return cars.size();
  }

  public void moveCars(int rounds) {
    for (int i = 0; i < rounds; i++) {
      for (Car car : cars) {
        car.move(random.nextInt(BOUND));
      }
    }
  }

  public String getCarsStatus() {
    return cars.stream()
        .map(Car::showStatus)
        .collect(Collectors.joining(System.lineSeparator()));
  }
}
