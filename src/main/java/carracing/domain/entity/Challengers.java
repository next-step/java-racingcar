package carracing.domain.entity;

import java.util.ArrayList;
import java.util.List;

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

  public String toStringOfStep() {
    StringBuilder sb = new StringBuilder();
    for (Car car : challengers) {
      sb.append(car.toStringOfStep()).append(System.lineSeparator());
    }
    return sb.toString();
  }

  public String startRound(int standard) {
    for (Car car : challengers) {
      car.move(standard);
    }
    return toStringOfStep();
  }

  public int getSize() {
   return this.challengers.size();
  }
}
