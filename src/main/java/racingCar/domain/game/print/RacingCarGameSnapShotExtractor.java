package racingCar.domain.game.print;

import java.util.List;
import racingCar.domain.car.RacingCar;

public interface RacingCarGameSnapShotExtractor {
  String extractSnapShot (List<RacingCar> racingCars);
}
