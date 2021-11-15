package carracing.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

public class Challengers {

  private final List<Car> challengers;

  public Challengers(Participant participant) {
    if (participant == null || participant.size() == 0) {
      throw new IllegalArgumentException();
    }
    this.challengers = new ArrayList<>(participant.size());
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
}
