package racingcar;

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

  public void initialize(int size) {
    List<Car> newCars = new ArrayList<>();

    for (int i = 0; i < size; i++) {
      newCars.add(new Car());
    }

    this.cars = Collections.unmodifiableList(newCars);
  }

  public int getCarCount() {
    return cars.size();
  }

  public void moveAll() {
    cars.forEach(car -> car.move(random.nextInt(BOUND)));
  }

  public String getStatus() {
    return cars.stream()
        .map(Car::showStatus)
        .collect(Collectors.joining(System.lineSeparator()));
  }
}
