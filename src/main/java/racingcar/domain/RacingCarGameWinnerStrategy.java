package racingcar.domain;

import java.util.List;

public interface RacingCarGameWinnerStrategy {
    List<RacingCar> getWinners(List<RacingCar> racingCars);
}
