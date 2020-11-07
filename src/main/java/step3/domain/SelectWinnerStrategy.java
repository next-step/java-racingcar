package step3.domain;

import java.util.List;

public interface SelectWinnerStrategy {
    List<RacingCar> select(final List<RacingCar> racingCars);
}
