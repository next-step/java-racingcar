package racing.service;

import java.util.ArrayList;
import java.util.List;
import racing.dto.RacingInput;
import racing.dto.RacingOutput;
import racing.object.Car;
import racing.strategy.MoveStrategy;

public class RacingService {

  private final MoveStrategy moveStrategy;

  public RacingService(MoveStrategy moveStrategy) {
    this.moveStrategy = moveStrategy;
  }

  public List<RacingOutput> race(RacingInput racingInput) {
    List<RacingOutput> racingOutputs = new ArrayList<>();
    List<Car> cars = makeCars(racingInput.getCarCount());

    for (int i = 0; i < racingInput.getAttemptCount(); i++) {
      racingOutputs.add(race(cars));
    }
    return racingOutputs;
  }

  private List<Car> makeCars(int carCount) {
    List<Car> cars = new ArrayList<>();
    for (int i = 0; i < carCount; i++) {
      cars.add(new Car(moveStrategy));
    }
    return cars;
  }

  private RacingOutput race(List<Car> cars) {
    for (int j = 0; j < cars.size(); j++) {
      cars.get(j).attempt();
    }
    return new RacingOutput(cars);
  }
}
