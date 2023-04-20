package racingCar.domain.game.print;

import java.util.List;
import java.util.stream.Collectors;
import racingCar.domain.car.RacingCar;

public class BaseRacingCarGameSnapShotExtractor implements RacingCarGameSnapShotExtractor {

  @Override
  public String extractSnapShot(List<RacingCar> racingCars) {
    return racingCars.stream()
        .map(this::getVisualRacingCarDistance)
        .collect(Collectors.joining("\n"));
  }

  private String getVisualRacingCarDistance(RacingCar racingCar) {
    int racingCarPosition = racingCar.getPosition();
    StringBuilder sb = new StringBuilder();
    sb.append(racingCar.getCarName());
    sb.append(" : ");

    for (long i = 0; i < racingCarPosition; i++) {
      sb.append('-');
    }
    return sb.toString();
  }
}
