package racinggame;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racinggame.model.MovingResult;
import racinggame.model.RacingCars;
import racinggame.model.RacingResult;
import racinggame.vo.RacingInfo;

public class CarRacing {

  private final int roundCount;
  private final RacingCars racingCars;

  public CarRacing(RacingInfo racingInfo) {
    this.roundCount = racingInfo.getRoundCount();
    this.racingCars = new RacingCars(racingInfo.getRacingCarCount());
  }

  public RacingResult startRacing() {
    return new RacingResult(running(this.racingCars));
  }

  private List<MovingResult> running(RacingCars racingCars) {
    return IntStream.range(0, this.roundCount)
        .mapToObj(index -> racingCars.racing())
        .collect(Collectors.toList());
  }
}
