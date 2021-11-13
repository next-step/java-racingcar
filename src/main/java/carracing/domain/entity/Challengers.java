package carracing.domain.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BooleanSupplier;

import static java.util.stream.Collectors.toList;

public class Challengers {

  private final List<Car> challengers;

  public Challengers(Participant participant) {
    if (participant == null || participant.getParticipant().size() == 0) {
      throw new IllegalArgumentException();
    }
    this.challengers = new ArrayList<>(participant.getParticipant().size());
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
