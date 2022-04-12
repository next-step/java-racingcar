package racing.domain.dto;

import java.util.ArrayList;
import java.util.List;
import racing.domain.Car;

public class RacingOutput {

  private List<Integer> distances;

  public RacingOutput(List<Car> cars) {
    this.distances = new ArrayList<>();
    for (Car c : cars) {
      this.distances.add(c.getDistance());
    }
  }

  public List<Integer> getDistances() {
    return distances;
  }

}
