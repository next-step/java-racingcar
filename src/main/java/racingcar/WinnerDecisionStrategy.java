package racingcar;

import java.util.List;

public interface WinnerDecisionStrategy {
    List<Car> decideWinners(List<Car> allParticipants);
}
