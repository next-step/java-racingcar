package racingCar.domain;

import java.util.List;

@FunctionalInterface
public interface WinnerPolicy {

    List<String> winnerDecision(List<RacingCar> cars);
}
