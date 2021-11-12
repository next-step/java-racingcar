package carracing.domain.entity;

import carracing.domain.dto.RacingData;
import carracing.domain.dto.RoundResult;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

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

  public RoundResult startRound(Supplier<Boolean> isMoved) {
    List<RacingData> racingDataList = new ArrayList<>();
    for (Car car : getChallengers()) {
      racingDataList.add(car.move(isMoved));
    }
    return new RoundResult(racingDataList);
  }

  public List<Car> getChallengers() {
    return challengers;
  }
}
