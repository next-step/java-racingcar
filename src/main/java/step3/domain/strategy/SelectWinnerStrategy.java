package step3.domain.strategy;

import step3.domain.RacingCar;

import java.util.List;

public interface SelectWinnerStrategy {
    List<RacingCar> select(final List<RacingCar> racingCars);
}
