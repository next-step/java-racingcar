package carracing.domain.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BooleanSupplier;

import static java.util.stream.Collectors.toList;

public class Challengers {

  private static final int FIRST_INDEX = 0;

  private final List<Car> challengers;

  public Challengers() {
    this.challengers = new ArrayList<>();
  }

  public static Challengers from(List<Car> carList) {
    final Challengers challengers = new Challengers();
    challengers.challengers.addAll(carList);
    return challengers;
  }

  public void register(Car car) {
    challengers.add(car);
  }

  public void notifyCarOfStart(BooleanSupplier isMovable) {
    for (Car car : getChallengers()) {
      car.move(isMovable);
    }
  }

  public List<Car> getChallengers() {
    return challengers;
  }

  public Challengers getWinner() {
    List<Car> carList = new ArrayList<>(this.challengers);
    Collections.sort(carList);
    return from(findWinner(carList));
  }

  private List<Car> findWinner(List<Car> carList) {
    Car firstCar = carList.get(FIRST_INDEX);
    return carList.stream()
                  .filter(firstCar::equalStep)
                  .collect(toList());
  }
}
