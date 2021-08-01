package racingCar.domain;

import java.util.List;

@FunctionalInterface
public interface WinnerPolicy {

    List<RacingCar> winnerDecision(List<RacingCar> cars);
}
