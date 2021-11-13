package carracing.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

public class Challengers {

  private List<Car> challengers;

  public Challengers(Number number) {
    if (number == null) {
      throw new IllegalArgumentException();
    }
    this.challengers = new ArrayList<>(number.getValue());
  }

  public void register(Car car) {
    challengers.add(car);
  }

  public List<Car> startRound(BooleanSupplier isMovable) {
    for (Car car : getChallengers()) {
      car.move(isMovable);
    }
    return this.challengers;
  }

  public List<Car> getChallengers() {
    return challengers;
  }
}
