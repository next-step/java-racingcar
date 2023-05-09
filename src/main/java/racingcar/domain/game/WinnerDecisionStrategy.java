package racingcar.domain.game;

import racingcar.domain.car.Car;
import racingcar.domain.car.Winners;

import java.util.List;

public interface WinnerDecisionStrategy {
    Winners decideWinners(List<Car> allParticipants);
}
